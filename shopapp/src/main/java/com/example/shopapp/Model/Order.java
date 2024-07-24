package com.example.shopapp.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Data  // Tạo getter, setter, toString, equals, và hashCode
@NoArgsConstructor  // Tạo constructor không tham số
@AllArgsConstructor  // Tạo constructor với tất cả các tham số
@Getter
@Setter
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "fullname", nullable = false, length = 255)
    private String fullname;

    @Column(name = "phone_number", nullable = false, length = 255)
    private String phone_number;

    @Column(name = "address", nullable = false, length = 255)
    private String address;

    @Column(name = "note", nullable = false, length = 255)
    private String note;

    @Column(name = "order_date", nullable = false, length = 255)
    private LocalDateTime order_date;

    @Column(name = "status", nullable = false, length = 255)
    private String status;

    @Column(name = "total_money", nullable = false, length = 255)
    private Float total_money;

    @Column(name = "shipping_method", nullable = false, length = 255)
    private String shipping_method;

    @Column(name = "shipping_address", nullable = false, length = 255)
    private String shipping_address;

    @Column(name = "shipping_date", nullable = false, length = 255)
    private LocalDateTime shipping_date;

    @Column(name = "tracking_number", nullable = false, length = 255)
    private String tracking_number;

    @Column(name = "payment_method", nullable = false, length = 255)
    private String payment_method;

    @Column(name = "active", nullable = false, length = 255)
    private Boolean active;
    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        order_date = now;
    }

    @PreUpdate
    protected void onUpdate() {
        order_date = LocalDateTime.now();
    }

}
