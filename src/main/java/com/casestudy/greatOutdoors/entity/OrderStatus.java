package com.casestudy.greatOutdoors.entity;

import javax.persistence.*;

@Entity
public class OrderStatus {

    @Id
    @GeneratedValue
    private int id;
    private String status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_code")
    private Product product ;
}
