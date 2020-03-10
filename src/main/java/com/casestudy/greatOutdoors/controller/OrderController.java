package com.casestudy.greatOutdoors.controller;


import com.casestudy.greatOutdoors.dao.OrderRepository;
import com.casestudy.greatOutdoors.dao.ProductRepository;
import com.casestudy.greatOutdoors.entity.Order;
import com.casestudy.greatOutdoors.entity.Product;
import com.casestudy.greatOutdoors.form.ProductCustomerForm;
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
    ProductRepository productrepo;

    @Autowired
    OrderRepository orderrepo;

    @RequestMapping(value ="/customer/product", method = RequestMethod.GET)
    public String showAvailableProducts(ModelMap model){
        List<Product> products = productrepo.findAll();
        model.put("products",products);
        return "customer_products";
    }

    @RequestMapping(value ="/buy_now", method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam String code,Order order, ModelMap model) {
        Product product = productrepo.findById(code).get();
        model.addAttribute("order",order);
        model.addAttribute("product",product);


        return "customer_details";
    }

    @RequestMapping(value ="/place_order", method = RequestMethod.POST)
    public String placeOrder(ModelMap model, Order order, @RequestParam("name") String code) {
        Product product = productrepo.findById(code).get();
        order.setProduct(product);
        order.setOrderDate(new Date());
        orderrepo.save(order);

        return "success";
    }
}
