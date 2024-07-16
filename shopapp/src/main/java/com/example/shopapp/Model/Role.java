package com.example.shopapp.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "roles")
@Data  // Tạo getter, setter, toString, equals, và hashCode
@NoArgsConstructor  // Tạo constructor không tham số
@AllArgsConstructor  // Tạo constructor với tất cả các tham số
@Getter
@Setter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name" , nullable = false)
    private String name;

}
