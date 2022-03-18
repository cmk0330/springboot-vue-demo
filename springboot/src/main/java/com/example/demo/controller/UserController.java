package com.example.demo.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.RedisCacheUtils;
import com.example.demo.common.RedisUtils;
import com.example.demo.common.Result;
import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.Random;

@RestController
@RequestMapping("/user")
public class UserController {

    final
    UserService userService;
    @Resource
    UserMapper mapper;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    RedisCacheUtils redisCacheUtils;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public Result<?> login(@RequestBody User user) {
        User res = mapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getUsername, user.getUsername())
                .eq(User::getPassword, user.getPassword()));
        if (res == null) Result.error("-1", "用户名货密码错误");

        return Result.success();
    }

    @PostMapping
    public Result<?> save(@RequestBody User user) {
        ValueOperations operations = redisTemplate.opsForValue();
        operations.set("test", user);
        Boolean exits = operations.getOperations().hasKey("test");
        System.out.println("redis是否存在相应的key" + exits);
        User user1 = (User) operations.get("test");
        userService.insert(user);
        System.out.println("数据库读取的" + user1);
//        mapper.insert(user);
        return Result.success();
    }

    @PutMapping
    public Result<?> upDate(@RequestBody User user) {
        int i = userService.upDate(user);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        int i = userService.deleteById(id);
        System.out.println(i);
        return Result.success();
    }

    @GetMapping
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "") String search) {
        ValueOperations operations = redisTemplate.opsForValue();
        Page<User> userPage = userService.selectPage(new Page<>(pageNum, pageSize),
                Wrappers.<User>lambdaQuery().like(User::getNickName, search));
        operations.set("userPage", userPage);
        Page<User> userPage1 = (Page<User>) operations.get("userPage");
        System.out.println(userPage1);
        return Result.success(userPage);
    }

    @GetMapping("/{id}")
    public Result<?> selectId(@PathVariable("id") int id) {
        String key = "user" + id;
        User user = (User) redisCacheUtils.getValueOfObject(key);
        String keySign = key + "_sign";
        String valueSign = redisCacheUtils.getValue(keySign);
        if (user == null) {//防止第一次查询时返回时空结果
            //防止缓存穿透
            if (redisCacheUtils.exists(key)) {
                return null;
            }
            user = mapper.selectById(id);

            redisCacheUtils.set(key, user);
            redisCacheUtils.set(keySign, "1", (long)(3000 * (new Random().nextInt(10) + 1)));
//            redisCacheUtil.set(keySign,"1",0L);  //过期时间不能设置为0，必须比0大的数
            return Result.success(user);
        }

        if (valueSign != null) {
            return Result.success(user);
        } else {
            //设置标记的实效时间
            long tt = 3000 * (new Random().nextInt(10) + 1);
            System.out.println("tt:" + tt);
            redisCacheUtils.set(keySign, "1", tt);
            //异步处理缓存更新  应对与高并发的情况，会产生脏读的情况
            new Thread(()->{
                System.out.println("-----执行异步操作-----");
                User user1 = mapper.selectById(id);
                redisCacheUtils.set(key, user1);
            }).start();


//            new Thread(){
//                public void run() { //应对与高并发的情况，会产生脏读的情况
//                    System.out.println("-----执行异步操作-----");
//                    User user1 = userMapper.selectByPrimaryKey(userId);
//                    redisCacheUtil.set(key,user1);
//                }
//            }.start();
        }
        return Result.success(user);
    }
}
