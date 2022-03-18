package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.pojo.User;

public interface UserService {

    void insert(User user);

    int upDate(User user);

    int deleteById(Long id);


    Page<User> selectPage(Page<User> page, Wrapper<User> queryWrapper);

    User getUserById(int id);
}
