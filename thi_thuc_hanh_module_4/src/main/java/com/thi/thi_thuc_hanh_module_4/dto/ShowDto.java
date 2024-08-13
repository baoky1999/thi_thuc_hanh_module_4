package com.thi.thi_thuc_hanh_module_4.dto;

import com.thi.thi_thuc_hanh_module_4.model.Product;
import com.thi.thi_thuc_hanh_module_4.model.ProductCatecury;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ShowDto {
    private List<ProductDto> productList;
    private List<OrderDto> orderList;
    private List<ProductCategoryDto> productCategoryList;

    @Data
    public static class ProductDto {
        private int id;
        private String name;
        private int price;
        private String description;
        private ProductCategoryDto productCategory;
    }

    @Data
    public static class OrderDto {
        private int id;
        private LocalDate dateBuy;
        private int quantity;
        private ProductDto product;
    }

    @Data
    public static class ProductCategoryDto {
        private int id;
        private String name;
    }
}
