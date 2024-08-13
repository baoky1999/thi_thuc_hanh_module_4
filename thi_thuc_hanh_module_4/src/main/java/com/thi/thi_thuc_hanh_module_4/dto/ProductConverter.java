package com.thi.thi_thuc_hanh_module_4.dto;

import com.thi.thi_thuc_hanh_module_4.model.Order;
import com.thi.thi_thuc_hanh_module_4.model.Product;
import com.thi.thi_thuc_hanh_module_4.model.ProductCatecury;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    public ShowDto.ProductDto toProductDto(Product product) {
        ShowDto.ProductDto dto = new ShowDto.ProductDto();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        dto.setDescription(product.getDescription());

        if (product.getProductCatecury() != null) {
            ShowDto.ProductCategoryDto categoryDto = new ShowDto.ProductCategoryDto();
            categoryDto.setId(product.getProductCatecury().getId());
            categoryDto.setName(product.getProductCatecury().getName());
            dto.setProductCategory(categoryDto);
        }

        return dto;
    }

    public ShowDto.OrderDto toOrderDto(Order order) {
        ShowDto.OrderDto dto = new ShowDto.OrderDto();
        dto.setId(order.getId());
        dto.setDateBuy(order.getDateBuy());
        dto.setQuantity(order.getQuantity());

        if (order.getProduct() != null) {
            ShowDto.ProductDto productDto = toProductDto(order.getProduct());
            dto.setProduct(productDto);
        }

        return dto;
    }

    public ShowDto.ProductCategoryDto toProductCategoryDto(ProductCatecury category) {
        ShowDto.ProductCategoryDto dto = new ShowDto.ProductCategoryDto();
        dto.setId(category.getId());
        dto.setName(category.getName());
        return dto;
    }
}
