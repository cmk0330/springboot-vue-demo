package com.example.demo.controller;

import com.example.demo.common.Result;
import com.example.demo.pojo.Category;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService service;

    @GetMapping("/all")
    public Result<?> getCategory() {
        List<Category> categoryAll = service.getCategoryAll();
        return Result.success(categoryAll);
    }
}
