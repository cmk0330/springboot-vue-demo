package com.example.demo.service;

import com.example.demo.mapper.MessageMapper;
import com.example.demo.pojo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    final
    MessageMapper mapper;

    public MessageServiceImpl(MessageMapper mapper) {
        this.mapper = mapper;
    }


    @Override
    public List<Message> getMessage() {
        return mapper.getMessage();
    }
}
