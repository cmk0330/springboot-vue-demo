package com.example.demo.service;

import com.example.demo.repository.PageResponse;
import com.example.demo.pojo.Order;

import java.util.List;

public interface OrderService {
    void saveAll(List<Order> orders);

    Order findById(Integer id);

    void deleteById(Integer id);

    void updateById(Order order);

    PageResponse<Order> findList(Order order, Integer pageIndex, Integer pageSize);

    PageResponse<Order> findAll(Integer pageIndex, Integer pageSize);

    PageResponse<Order> findHighlight(Order order, Integer pageIndex, Integer pageSize);
}
