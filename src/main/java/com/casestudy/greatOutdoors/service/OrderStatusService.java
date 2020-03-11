package com.casestudy.greatOutdoors.service;


import com.casestudy.greatOutdoors.dao.OrderStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderStatusService {

    @Autowired
    OrderStatusRepository orderStatusRepository;


}
