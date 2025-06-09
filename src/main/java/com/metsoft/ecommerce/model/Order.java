package com.metsoft.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


import java.util.Date;
import java.util.List;
import java.util.HashMap;
import java.util.Map;



@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "creation_date")
    private Date creationDate;

    public void setCreationDate(Date date) {
        this.creationDate=date;
    }

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private OrderStatus status;


    @ManyToMany()
    @JoinTable(
            name = "order_items",
            joinColumns = @JoinColumn(name = "orderItem_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;


    @ElementCollection
    @CollectionTable(name = "order_product_quantities", joinColumns = @JoinColumn(name = "order_id"))
    @MapKeyJoinColumn(name = "product_id")
    @Column(name = "quantity")
    private java.util.Map<Product, Integer> productQuantities = new HashMap<>();

}
