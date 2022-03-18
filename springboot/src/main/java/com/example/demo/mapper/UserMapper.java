package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Override
    int insert(User entity);

    @Override
    int updateById(User entity);

    @Override
    int deleteById(Serializable id);

    @Override
    User selectById(Serializable id);

    @Override
    default User selectOne(Wrapper<User> queryWrapper) {
        return null;
    }

    @Override
    <P extends IPage<User>> P selectPage(P page, @Param("ew") Wrapper<User> queryWrapper);
}
