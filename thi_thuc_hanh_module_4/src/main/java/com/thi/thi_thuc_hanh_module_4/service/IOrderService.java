package com.thi.thi_thuc_hanh_module_4.service;

import com.thi.thi_thuc_hanh_module_4.model.Order;

import java.time.LocalDate;
import java.util.List;

public interface IOrderService {
    List<Order> findAll();

    List<Order> findByDateBuyBetween(LocalDate first, LocalDate second);

    Order findById(int id);

    void save(Order order);
}
