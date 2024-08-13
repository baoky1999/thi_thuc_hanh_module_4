package com.thi.thi_thuc_hanh_module_4.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "order_detail")
@Data
public class Order {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "ma_don_hang")
    private int id;

    @Column (name = "ngay_mua")
    private LocalDate dateBuy;

    @Column (name = "so_luong")
    private int quantity;

    @ManyToOne
    @JoinColumn (name = "ma_sp")
    private Product product;

}
