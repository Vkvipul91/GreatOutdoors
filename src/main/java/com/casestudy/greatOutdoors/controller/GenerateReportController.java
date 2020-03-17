package com.casestudy.greatOutdoors.controller;

import com.casestudy.greatOutdoors.dao.OrderRepository;
import com.casestudy.greatOutdoors.entity.Order;
import com.casestudy.greatOutdoors.entity.Product;
import com.casestudy.greatOutdoors.service.OrderService;
import com.casestudy.greatOutdoors.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
public class GenerateReportController {


    @Autowired
    OrderService orderService;

    @RequestMapping(value ="/admin/order_report", method = RequestMethod.GET)
    public String orderCompletedReport(ModelMap model){
        String status = "completed";
        List<Order> orderList = orderService.getOrdersByStatus(status);
        model.addAttribute("orderCompletedList",orderList);
        return "admin_order_report";
    }

    @RequestMapping(value ="/admin/refund_report", method = RequestMethod.GET)
    public String orderRefundReport(ModelMap model){
        String status = "refund initiated";
        List<Order> orderList = orderService.getOrdersByStatus(status);
        model.addAttribute("orderRefundList",orderList);
        return "admin_refund_report";
    }


    @RequestMapping(value ="/admin/hot_product", method = RequestMethod.GET)
    public String getMostSellingProduct(ModelMap model){
        String status = "completed";
        Map<Product,Integer> productMap = orderService.getTopSellingProduct(status);
        int count = 0;
        Set<Product> products = productMap.keySet();
        for(Product product:products){
           count = productMap.get(product);
        }
        model.addAttribute("productSet",products);
        model.addAttribute("count",count);
        return "top_product";
    }
}
