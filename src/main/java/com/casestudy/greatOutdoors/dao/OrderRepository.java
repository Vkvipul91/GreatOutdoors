package com.casestudy.greatOutdoors.dao;

import com.casestudy.greatOutdoors.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,String> {
    List<Order> findByCustomerName(String customerName);
}
