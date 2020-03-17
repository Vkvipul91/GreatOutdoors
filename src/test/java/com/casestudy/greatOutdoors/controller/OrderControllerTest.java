package com.casestudy.greatOutdoors.controller;

import com.casestudy.greatOutdoors.dao.*;
import com.casestudy.greatOutdoors.entity.Product;
import com.casestudy.greatOutdoors.service.TestData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@WebMvcTest
public class OrderControllerTest {

    private TestData testData = new TestData();

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ProductRepository mockProductRepository;

    @MockBean
    OrderRepository mockOrderRepository;

    @MockBean
    OrderStatusRepository mockOrderStatusRepository;

    @MockBean
    AccountRepository mockAccountRepository;

    @MockBean
    CustomerRepository mockCustomerRepository;

    @Test
    public void testShowAvailableProducts() throws Exception {

        List<Product> productList = new ArrayList<Product>();
        int prodReqListSize = 5;
        for (int i = 0; i < prodReqListSize; i++) {
            Product product = testData.getProduct(i);
            productList.add(product);
        }
        when(mockProductRepository.findAll()).thenReturn(productList);

        this.mockMvc.perform(get("/customer/product"))
                //.andExpect(status().isOk())
                .andExpect(content().string(""));
                        //json("[{'id': 1,'name': 'Stock 1';'price': 1}]"));

    }

}