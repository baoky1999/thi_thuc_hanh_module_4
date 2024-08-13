package com.thi.thi_thuc_hanh_module_4.service.iml;

import com.thi.thi_thuc_hanh_module_4.model.Product;
import com.thi.thi_thuc_hanh_module_4.repository.IProductRepository;
import com.thi.thi_thuc_hanh_module_4.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll() ;
    }
}
