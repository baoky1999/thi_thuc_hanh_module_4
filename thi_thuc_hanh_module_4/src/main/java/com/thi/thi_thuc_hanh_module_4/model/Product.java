package com.thi.thi_thuc_hanh_module_4.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "product")
@Data
public class Product {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "ma_sp")
    private int id;

    @Column (name = "ten_sp")
    private String name;

    @Column (name = "gia_sp")
    private int price;

    @Column (name = "tinh_trang_sp")
    private String description;

    @ManyToOne
    @JoinColumn (name = "ma_loai_sp")
    private ProductCatecury productCatecury;
}
