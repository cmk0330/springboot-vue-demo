package com.example.demo.mapper;

import com.example.demo.pojo.Message;
import lombok.Data;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface MessageMapper {

    List<Message> getMessage();
}
