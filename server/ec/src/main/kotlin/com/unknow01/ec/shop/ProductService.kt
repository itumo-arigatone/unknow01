package com.unknow01.ec.shop
  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
  
import com.unknow01.ec.shop.Product;
import com.unknow01.ec.shop.ProductRepository;
  
@Service
class ProductService {
  
    @Autowired
    lateinit var prdRepository: ProductRepository;

    fun findAll(): List<Product> {
        return prdRepository.findAll();
    }
}