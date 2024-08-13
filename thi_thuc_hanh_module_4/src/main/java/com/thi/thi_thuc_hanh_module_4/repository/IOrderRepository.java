package com.thi.thi_thuc_hanh_module_4.repository;

import com.thi.thi_thuc_hanh_module_4.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface IOrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByDateBuyBetween(LocalDate first, LocalDate second);
}
