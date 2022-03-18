package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.RedisCacheUtils;
import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserServiceImpl implements UserService {

    final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Autowired
    RedisCacheUtils redisCacheUtil;


    @Cacheable(value= "user", keyGenerator = "wiselyKeyGenerator")
    @Override
    public void insert(User user) {
        long startTime = System.currentTimeMillis();
        BigDecimal bs = BigDecimal.valueOf(startTime);
        userMapper.insert(user);
        long endTime = System.currentTimeMillis();
        BigDecimal es = BigDecimal.valueOf(endTime);
        System.out.println("耗时：="+es.subtract(bs));
    }

    @Override
    public int upDate(User user) {
        return userMapper.updateById(user);
    }

    @Override
    public int deleteById(Long id) {
        return userMapper.deleteById(id);
    }


    @Override
    public Page<User> selectPage(Page<User> page, Wrapper<User> queryWrapper) {
        return userMapper.selectPage(page, queryWrapper);
    }

//    @Cacheable(value = "user", keyGenerator = "wiselyKeyGenerator")
    @Override
    public User getUserById(int id) {
        return userMapper.selectById(id);
    }
}
