package com.unknow01.ec.shop

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import com.unknow01.ec.shop.Product;
import com.unknow01.ec.shop.ProductService;

@RestController
@RequestMapping("/products")
class ProductController {

    @Autowired
    lateinit var prdService: ProductService;

	@GetMapping("/all")
	fun index(): List<Product> {
        return prdService.findAll();
	}
}