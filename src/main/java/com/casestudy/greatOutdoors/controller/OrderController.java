package com.casestudy.greatOutdoors.controller;


import com.casestudy.greatOutdoors.dao.OrderRepository;
import com.casestudy.greatOutdoors.dao.ProductRepository;
import com.casestudy.greatOutdoors.entity.Order;
import com.casestudy.greatOutdoors.entity.Product;
import com.casestudy.greatOutdoors.service.OrderService;
import com.casestudy.greatOutdoors.service.OrderStatusService;
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
    ProductRepository productrepo;

    @Autowired
    OrderRepository orderrepo;
    @Autowired
    OrderService orderService;

    @Autowired
    ProductService productService;

    @Autowired
    OrderStatusService orderStatusService;

    @RequestMapping(value ="/customer/product", method = RequestMethod.GET)
    public String showAvailableProducts(ModelMap model){
        List<Product> products = productrepo.findAll();
        model.put("products",products);
        return "customer_product_list";
    }

    @RequestMapping(value ="/buy_now", method = RequestMethod.POST)
    public String showUpdateTodoPage(@RequestParam("pcode") String code,@RequestParam("quantity") String quantity,Order order, ModelMap model) {
        Product product = productrepo.findById(code).get();
        order.setQuantity(Integer.parseInt(quantity));
        double total_amt = 100*(order.getQuantity());

        System.out.println(total_amt);
        order.setBill(total_amt);
        model.addAttribute("order",order);
        model.addAttribute("product",product);


        return "customer_shipping_details";
    }

    @RequestMapping(value ="/place_order", method = RequestMethod.POST)
    public String placeOrder(ModelMap model, Order order, @RequestParam("name") String code,
                             @RequestParam("quantity") String quantity,@RequestParam("bill") String bill) {
        Product product = productrepo.findById(code).get();
        order.setProduct(product);
        order.setBill(Double.parseDouble(bill));
        order.setQuantity(Integer.parseInt(quantity));
        order.setOrderDate(new Date());
        orderrepo.save(order);

        return "success";
    }
    @RequestMapping(value ="/order_status", method = RequestMethod.GET)
    public String orderStatus(ModelMap model){
       String customerName = "vipul";
        List<Order> orderHistoryList= orderService.findOrderHistory(customerName);
        model.put("orderHistory",orderHistoryList);
        Order order = orderHistoryList.get(9);
        Product product = order.getProduct();
        product.getName();
        //Product product = productService.getProductDetails(orderHistoryList.get(8));
        model.put("product",product);
        return "order_history";
    }
}
