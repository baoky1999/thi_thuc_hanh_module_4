package com.thi.thi_thuc_hanh_module_4.repository;

import com.thi.thi_thuc_hanh_module_4.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface IOrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByDateBuyBetween(LocalDate first, LocalDate second);


    @Query("SELECT o FROM Order o JOIN FETCH o.product p ORDER BY (o.quantity * p.price) DESC")
    Page<Order> findTopOrders(Pageable pageable);

}
