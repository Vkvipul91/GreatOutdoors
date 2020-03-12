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


    public Order newOrder(Order order, Product product, String username) {
        order.setProduct(product);
        order.setCustomerName(username);
        order.setStatus("initiated");
        double unitprice = product.getPrice();
        int quantity = order.getQuantity();
        double total_amt = this.calculateAmount(unitprice,quantity);
        order.setBill(total_amt);
        Order createdOrder = orderrepository.save(order);
        this.createOrderStatus(createdOrder);
        return createdOrder;
    }

    private double calculateAmount(double unitprice, int quantity) {
        double total_amount = unitprice*quantity;
        return total_amount;
    }

    public void createOrderStatus(Order order){

        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setStatus(order.getStatus());
        orderStatus.setOrder(order);
        orderStatus.setUpdatedAt(new Date());

        orderStatusRepository.save(orderStatus);
    }

    public void placeOrder(Order order, Product product) {
        Order orderFound = orderrepository.findById(order.getId()).get();
        orderFound.setStatus("completed");
        orderFound.setProduct(product);
        orderFound.setOrderDate(new Date());
        orderrepository.save(orderFound);
        this.createOrderStatus(orderFound);
    }


}
