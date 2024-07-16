package com.example.shopapp.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "products")
@Data  // Tạo getter, setter, toString, equals, và hashCode
@NoArgsConstructor  // Tạo constructor không tham số
@AllArgsConstructor  // Tạo constructor với tất cả các tham số
@Getter
@Setter
public class Product extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", length = 350, nullable = false, columnDefinition = "varchar(350) COMMENT 'Tên sản phẩm'")
    private String name;

    @Column(name = "price", nullable = false, columnDefinition = "float not null COMMENT 'Giá sản phẩm'")
    private Float price;

    @Column(name = "thumbnail", length = 300, columnDefinition = "varchar(300) DEFAULT '' COMMENT 'Ảnh sản phẩm'")
    private String thumbnail;

    // Nếu có quan hệ với Category, bạn có thể thêm thuộc tính và ánh xạ sau:
    @Column(name = "description",length=300)
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;


}
