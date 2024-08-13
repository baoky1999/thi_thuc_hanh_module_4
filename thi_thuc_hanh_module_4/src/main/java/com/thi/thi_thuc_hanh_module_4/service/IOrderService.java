package com.thi.thi_thuc_hanh_module_4.service;

import com.thi.thi_thuc_hanh_module_4.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

public interface IOrderService {
    List<Order> findAll();

    List<Order> findByDateBuyBetween(LocalDate first, LocalDate second);

    Order findById(int id);

    void save(Order order);


    Page<Order> findTopOrders(Pageable pageable);
}
