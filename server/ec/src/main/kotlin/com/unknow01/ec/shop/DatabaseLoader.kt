package com.unknow01.ec.shop

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.unknow01.ec.shop.ProductRepository;
import com.unknow01.ec.shop.Product;

@Component
class DatabaseLoader: CommandLineRunner {
    var repository: ProductRepository;

    @Autowired
    constructor(repository: ProductRepository) {
        this.repository = repository;
    }

    override fun run(vararg strings: String) {
        this.repository.save(Product("sample", "This is Sample!"));
    }
}