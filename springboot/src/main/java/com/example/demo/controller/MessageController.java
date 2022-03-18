package com.example.demo.controller;

import com.example.demo.common.Result;
import com.example.demo.pojo.Message;
import com.example.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/msg")
public class MessageController {

    @Autowired
    MessageService service;

    @GetMapping("/all")
    public Result<?> getMessage() {
        List<Message> message = service.getMessage();
        return Result.success(message);
    }
}
