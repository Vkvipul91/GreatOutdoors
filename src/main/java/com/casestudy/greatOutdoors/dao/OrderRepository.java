package com.casestudy.greatOutdoors.dao;

import com.casestudy.greatOutdoors.entity.Order;
import com.casestudy.greatOutdoors.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Integer> {
    List<Order> findByCustomerName(String customerName);

    @Query("SELECT c.product, count(c) FROM Order c WHERE c.status = :status GROUP BY c.product ORDER BY count(c) DESC")
    List<Object[]> findByProduct(String status);

    List<Order> findByStatus(String status);
}
