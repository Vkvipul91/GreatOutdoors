package com.casestudy.greatOutdoors.service;

import com.casestudy.greatOutdoors.dao.OrderRepository;
import com.casestudy.greatOutdoors.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderrepo;


    public List<Order> findOrderHistory(String customerName) {
        List<Order> orderHistoryList =orderrepo.findByCustomerName(customerName);
        return orderHistoryList;
    }


}
