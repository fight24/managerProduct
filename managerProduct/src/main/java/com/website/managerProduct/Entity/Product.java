package com.website.managerProduct.Entity;


import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "product")
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idproduct")
    private int idProduct;
    @Column(name = "productcode")
    private String productCode;
    @Column(name = "status")
    private boolean status;
    public Product(String productCode,boolean status){
        this.productCode = productCode;
        this.status = status;

    }

}
