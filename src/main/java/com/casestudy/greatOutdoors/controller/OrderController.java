package com.casestudy.greatOutdoors.controller;


import com.casestudy.greatOutdoors.dao.OrderRepository;
import com.casestudy.greatOutdoors.dao.ProductRepository;
import com.casestudy.greatOutdoors.entity.Order;
import com.casestudy.greatOutdoors.entity.Product;
import com.casestudy.greatOutdoors.service.OrderService;
import com.casestudy.greatOutdoors.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
public class OrderController {



    @Autowired
    OrderService orderService;

    @Autowired
    ProductService productService;


    @RequestMapping(value ="/customer/product", method = RequestMethod.GET)
    public String showAvailableProducts(ModelMap model){
        List<Product> products = productService.getAllPorducts();
        model.put("products",products);
        return "customer_product_list";
    }

    @RequestMapping(value ="/customer/buy_now", method = RequestMethod.POST)
    public String initiateOrder(@RequestParam("pcode") String code,Order order, ModelMap model) {
        String username = "vipul";
        Product product = productService.getProduct(code);
        Order orderInserted = orderService.newOrder(order,product,username);
        model.addAttribute("order",orderInserted);
        return "customer_shipping_details";
    }

    @RequestMapping(value ="/customer/place_order", method = RequestMethod.POST)
    public String placeOrder(ModelMap model, Order order, @RequestParam("code") String code) {
        Product product = productService.getProduct(code);
        orderService.placeOrder(order,product);
        return "success";
    }

    @RequestMapping(value ="/order_status", method = RequestMethod.GET)
    public String orderStatus(ModelMap model){
       String customerName = "vipul";
        List<Order> orderHistoryList= orderService.findOrderHistory(customerName);
        model.put("orderHistory",orderHistoryList);
        return "order_history";
    }
}
