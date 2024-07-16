package com.example.shopapp.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "social_accounts")
@Data  // Tạo getter, setter, toString, equals, và hashCode
@NoArgsConstructor  // Tạo constructor không tham số
@AllArgsConstructor  // Tạo constructor với tất cả các tham số
@Getter
@Setter
public class SocialAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name ="provider" , nullable = false, length = 100)
    private String provider;

    @Column(name ="provider_id" , nullable = false, length = 100)
    private String provider_id;

    @Column(name ="name" , nullable = false, length = 100)
    private String name;

    @Column(name ="email" , nullable = false, length = 100)
    private String email;

}
