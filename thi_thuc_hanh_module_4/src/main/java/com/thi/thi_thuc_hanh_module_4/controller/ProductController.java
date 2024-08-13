package com.thi.thi_thuc_hanh_module_4.controller;

import com.thi.thi_thuc_hanh_module_4.model.Order;
import com.thi.thi_thuc_hanh_module_4.model.Product;
import com.thi.thi_thuc_hanh_module_4.model.ProductCatecury;
import com.thi.thi_thuc_hanh_module_4.service.IOrderService;
import com.thi.thi_thuc_hanh_module_4.service.IProductCatecuryService;
import com.thi.thi_thuc_hanh_module_4.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping(value = "/product-manager")
public class ProductController {
    @Autowired
    private IProductService productService;

    @Autowired
    private IOrderService orderService; ;

    @Autowired
    private IProductCatecuryService productCatecuryService;
    @GetMapping
    public String showProduct(Model model) {
        List<Product> productList = productService.findAll();
        List<Order> orderList = orderService.findAll();
        List<ProductCatecury> productCatecuryList = productCatecuryService.findAll();
        model.addAttribute("productList", productList);
        model.addAttribute("orderList", orderList);
        model.addAttribute("productCatecuryList", productCatecuryList);
        return "show-list";
    }


    @GetMapping("/date-search")
    public String dateSearch(@RequestParam(value = "first", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate first,
                             @RequestParam(value = "second", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate second,
                             Model model) {
        if (first == null || second == null) {
            return "redirect:/product-manager";
        }

        List<Order> orderList = orderService.findByDateBuyBetween(first,second);
        model.addAttribute("orderList", orderList);
        return "show-list";
    }

//    @GetMapping ("/search")
//    public String search(@RequestParam (value = "quantity") int quantity, Model model) {
//
//    }

    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable int id, Model model) {
        Order order = orderService.findById(id);
        model.addAttribute("order", order);
        List<ProductCatecury> productCatecuryList = productCatecuryService.findAll();
        model.addAttribute("productCatecuryList", productCatecuryList);
        return "edit-product";
    }

    @PostMapping("/update")
    public String updateProduct(@RequestParam("code") String code,
                                @RequestParam("buy") LocalDate buy,
                                @RequestParam("quanlity") int quanlity,
                                @RequestParam("id") int id,
                                Model model) {

        Order order = orderService.findById(id);
        order.setDateBuy(buy);
        order.setQuantity(quanlity);
        orderService.save(order);
        return "redirect:/product-manager";
    }

    @GetMapping("/search")
    public String getTopOrders(@RequestParam(value = "limit",defaultValue = "10") int limit , Model model) {
        Pageable pageable = PageRequest.of(0, limit);
        Page<Order> page = orderService.findTopOrders(pageable);
        List<Order> orderList = page.getContent();
        model.addAttribute("orderList", orderList);
        return "show-list";
    }
}
