package com.example.shopapp.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "product_images")
@Data  // Tạo getter, setter, toString, equals, và hashCode
@NoArgsConstructor  // Tạo constructor không tham số
@AllArgsConstructor  // Tạo constructor với tất cả các tham số
@Getter
@Setter
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name ="product_id")
    private Product product;

    @Column(name = "image_url", length = 300)
    private String imageUrl;


}
