package com.thi.thi_thuc_hanh_module_4.repository;

import com.thi.thi_thuc_hanh_module_4.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Integer> {
}
