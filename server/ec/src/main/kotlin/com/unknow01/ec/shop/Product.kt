package com.unknow01.ec.shop

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "products")
class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0;
    var productName: String = "";
    var description: String = "";

    constructor() {}
    constructor(productName: String, description: String) {
        this.productName = productName;
        this.description = description;
    }
    constructor(id: Long, productName: String, description: String) {
        this.id = id;
        this.productName = productName;
        this.description = description;
    }
/*
    fun getProductName(): String {
        return productName;
    }

    fun setProductName(productName: String) {
        this.productName = productName;
    }

    fun getDescription(): String {
        return description;
    }

    fun setDescription(description: String) {
        this.description = description;
    }
*/
    override fun hashCode(): Int {
        return Objects.hash(id, productName, description);
    }
    override fun toString(): String {
        return "Product{" +
            "id=" + id +
            ", productName='" + productName + "'" +
            ", description='" + description + "'" +
            "}";
    }

}