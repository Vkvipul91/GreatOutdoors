package com.casestudy.greatOutdoors.service;

import com.casestudy.greatOutdoors.entity.Customer;
import com.casestudy.greatOutdoors.entity.Order;
import com.casestudy.greatOutdoors.entity.OrderStatus;
import com.casestudy.greatOutdoors.entity.Product;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

public class TestData {

    public List<Order> getOrders(int noOfOrders) {

        List<Order> orders = new ArrayList<Order>();
        for (int i = 0; i < noOfOrders; i++) {
            Order order = new Order();

            order.setProduct(getProduct(i));
            order.setStatus("Completed" + i);
            order.setBill(Double.valueOf(i));
            order.setOrderDate(new Date());
            order.setId(i);
            order.setCustomerName("Customer" + i);
            order.setCustomer(getCustomer(i));
            orders.add(order);
        }
        System.out.println("##### orders" +orders.size());
        return orders;
    }
    public List<Product> getProductList(int size){
    List<Product> productList = new ArrayList<Product>();
        for (int i = 0; i < size; i++) {
        Product product = getProduct(i);
        productList.add(product);
    }
    return productList;
    }

    public Customer getCustomer(int code){

       return  new Customer();

    }

    public Product getProduct(int code){
        Product product = new Product();
        String _code = String.valueOf(code);
        product.setCode(_code);
        product.setCreateDate(new Date());
        product.setImage(_code.getBytes());
        product.setName("Product"+_code);
        product.setPrice(Double.valueOf(_code));
        return  product;
    }

    public OrderStatus getOrderStatus(int i) {
        OrderStatus orderStatus = new OrderStatus();
        Order order = getOrder(i);
        orderStatus.setOrder(order);
        orderStatus.setStatus("Initiated"+i);
        orderStatus.setUpdatedAt(new Date());
        orderStatus.setId(i);
        return  orderStatus;
    }

    public Order getOrderByStatus(int i, String status){
        System.out.println("***** init Order *****");
        Order order = new Order();

        order.setProduct(getProduct(i));
        order.setStatus(status+i);
        order.setBill(Double.valueOf(i));
        order.setOrderDate(new Date());
        order.setId(i);
        order.setCustomerName("Customer" + i);
        order.setCustomer(getCustomer(i));
        System.out.println("***** out Order"+order.getId());
        return order;
    }
    public OrderStatus getOrderStatus(int i, String status) {
        OrderStatus orderStatus = new OrderStatus();
        Order order = getOrder(i);
        orderStatus.setOrder(order);
        orderStatus.setStatus(status+i);
        orderStatus.setUpdatedAt(new Date());
        orderStatus.setId(i);
        return  orderStatus;
    }

    public Order getOrder(int i){
        System.out.println("***** init Order *****");
        Order order = new Order();

        order.setProduct(getProduct(i));
        order.setStatus("Initiated" + i);
        order.setBill(Double.valueOf(i));
        order.setOrderDate(new Date());
        order.setId(i);
        order.setCustomerName("Customer" + i);
        order.setCustomer(getCustomer(i));
        System.out.println("***** out Order"+order.getId());
        return order;
    }

}
