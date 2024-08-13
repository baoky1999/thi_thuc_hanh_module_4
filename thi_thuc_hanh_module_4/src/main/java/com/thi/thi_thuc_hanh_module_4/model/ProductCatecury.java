package com.thi.thi_thuc_hanh_module_4.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "product-catecury")
@Data
public class ProductCatecury {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "ma_loai_sp")
    private int id;

    @Column (name = "ten_loai_sp")
    private String name;
}
