package com.thi.thi_thuc_hanh_module_4.service.iml;

import com.thi.thi_thuc_hanh_module_4.model.ProductCatecury;
import com.thi.thi_thuc_hanh_module_4.repository.IProductCatecuryRepository;
import com.thi.thi_thuc_hanh_module_4.service.IProductCatecuryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCatecugyService implements IProductCatecuryService {

    @Autowired
    private IProductCatecuryRepository productCatecuryRepository;

    @Override
    public List<ProductCatecury> findAll() {
        return productCatecuryRepository.findAll();
    }
}
