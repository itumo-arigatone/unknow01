package com.unknow01.ec.shop

import org.springframework.data.repository.CrudRepository;
import com.unknow01.ec.shop.Product;

public interface ProductRepository: CrudRepository<Product, Long> {

}