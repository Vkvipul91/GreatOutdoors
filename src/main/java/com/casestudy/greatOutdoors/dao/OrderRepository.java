package com.casestudy.greatOutdoors.dao;

import com.casestudy.greatOutdoors.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,String> {
}
