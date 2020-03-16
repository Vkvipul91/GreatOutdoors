package com.casestudy.greatOutdoors.service;

import com.casestudy.greatOutdoors.dao.OrderRepository;
import com.casestudy.greatOutdoors.dao.OrderStatusRepository;
import com.casestudy.greatOutdoors.entity.Order;
import com.casestudy.greatOutdoors.entity.OrderStatus;
import com.casestudy.greatOutdoors.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderrepository;

    @Autowired
    OrderStatusRepository orderStatusRepository;



    public List<Order> findOrderHistory(String customerName) {
        List<Order> orderHistoryList =orderrepository.findByCustomerName(customerName);
        return orderHistoryList;
    }


    public Order newOrder(Order order) {
        Order createdOrder = orderrepository.save(order);
        this.createOrderStatus(createdOrder);
        return createdOrder;
    }


    public void createOrderStatus(Order order){

        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setStatus(order.getStatus());
        orderStatus.setOrder(order);
        orderStatus.setUpdatedAt(order.getOrderDate());

        orderStatusRepository.save(orderStatus);
    }

    public Order placeOrder(Order order) {
        Order orderInitiated = orderrepository.save(order);
        this.createOrderStatus(orderInitiated);
        return orderInitiated;

    }


    public Order getOrder(String orderId) {
        Order order = orderrepository.findById(Integer.parseInt(orderId)).get();
        return order;
    }

    public boolean processRefund(Order order) {
        if(order.getStatus().equals("completed")) {
            order.setStatus("Refunded");
            order.setOrderDate(new Date());
            orderrepository.save(order);
            this.createOrderStatus(order);
            return true;
        }
        return false;
    }
}
