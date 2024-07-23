/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mua88.services.impl;

import com.mua88.pojo.Product;
import com.mua88.repositories.ProductRepository;
import com.mua88.services.ProductService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MSI VN
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired  
    private ProductRepository productRepo;

    @Override
    public List<Product> getProducts(Map<String, String> params) {
        return this.productRepo.getProducts(params);
    }

    @Override
    public void addOrUpdate(Product p) {
        this.productRepo.addOrUpdate(p);
    }

}
