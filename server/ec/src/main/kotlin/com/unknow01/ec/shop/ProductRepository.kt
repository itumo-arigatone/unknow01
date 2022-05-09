package com.unknow01.ec.shop

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository
import com.unknow01.ec.shop.Product;

interface ProductRepository: JpaRepository<Product, Long> {
}