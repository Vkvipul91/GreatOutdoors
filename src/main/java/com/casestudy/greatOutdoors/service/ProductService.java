package com.casestudy.greatOutdoors.service;


import com.casestudy.greatOutdoors.dao.ProductRepository;
import com.casestudy.greatOutdoors.entity.Order;
import com.casestudy.greatOutdoors.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;


    public Product getProductDetails(Product product) {
       Product productDetails = productRepository.findById(product.getCode()).get();
       return productDetails;
    }
}


