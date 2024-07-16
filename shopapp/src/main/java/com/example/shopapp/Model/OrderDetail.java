package com.example.shopapp.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "order_details")
@Data  // Tạo getter, setter, toString, equals, và hashCode
@NoArgsConstructor  // Tạo constructor không tham số
@AllArgsConstructor  // Tạo constructor với tất cả các tham số
@Getter
@Setter
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "price",nullable = false)
    private float price;


    @Column(name = "number_of_products",nullable = false)
    private float number_of_products;

    @Column(name = "total_money",nullable = false)
    private float total_money;

    @Column(name = "color")
    private float color;


}
