package com.thi.thi_thuc_hanh_module_4.service.iml;

import com.thi.thi_thuc_hanh_module_4.model.Order;
import com.thi.thi_thuc_hanh_module_4.repository.IOrderRepository;
import com.thi.thi_thuc_hanh_module_4.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private IOrderRepository orderRepository;

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> findByDateBuyBetween(LocalDate first, LocalDate second) {
        return orderRepository.findByDateBuyBetween(first,second);
    }

    @Override
    public Order findById(int id) {
        return orderRepository.findById(id).get();
    }

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }
}
