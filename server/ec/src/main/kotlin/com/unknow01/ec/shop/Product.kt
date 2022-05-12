package com.unknow01.ec.shop

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "products")
class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long = 0;
    @Column(name = "product_name")
    lateinit var product_name: String;
    @Column(name = "description")
    lateinit var description: String;

    constructor() {}

    constructor(id: Long, product_name: String, description: String) {
        this.id = id;
        this.product_name = product_name;
        this.description = description;
    }
}