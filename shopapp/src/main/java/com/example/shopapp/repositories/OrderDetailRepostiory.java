package com.example.shopapp.repositories;

import com.example.shopapp.Model.Order;
import com.example.shopapp.Model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepostiory extends JpaRepository<OrderDetail,Long> {

}

