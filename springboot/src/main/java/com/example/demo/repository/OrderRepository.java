package com.example.demo.repository;

import com.example.demo.pojo.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class OrderRepository implements ElasticsearchRepository<Order, Integer> {

    @Override
    public Page<Order> searchSimilar(Order order, String[] strings, Pageable pageable) {
        return null;
    }

    @Override
    public Iterable<Order> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Order> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Order> S save(S s) {
        return null;
    }

    @Override
    public <S extends Order> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Order> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<Order> findAll() {
        return null;
    }

    @Override
    public Iterable<Order> findAllById(Iterable<Integer> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Order order) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> iterable) {

    }

    @Override
    public void deleteAll(Iterable<? extends Order> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
