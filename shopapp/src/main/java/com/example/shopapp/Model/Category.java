package com.example.shopapp.Model;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "categories")
@Data  // Tạo getter, setter, toString, equals, và hashCode
@NoArgsConstructor  // Tạo constructor không tham số
@AllArgsConstructor  // Tạo constructor với tất cả các tham số
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, length = 100, columnDefinition = "varchar(100) default '' COMMENT 'Tên danh mục, cd: đồ điện tử'")
    private String name;
}
