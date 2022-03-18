package com.example.demo.service;

import com.example.demo.mapper.CategoryMapper;
import com.example.demo.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper mapper;

    @Override
    public List<Category> getCategoryAll() {
        return mapper.getCategoryAll();
    }
}
