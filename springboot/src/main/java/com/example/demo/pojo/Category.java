package com.example.demo.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Category {
    private int id;
    private String name;
    private int pid;
}
