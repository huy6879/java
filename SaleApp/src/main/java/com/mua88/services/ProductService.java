/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mua88.services;

import com.mua88.pojo.Product;
import java.util.List;
import java.util.Map;

/**
 *
 * @author MSI VN
 */
public interface ProductService {

    public List<Product> getProducts(Map<String, String> params);

    public void addOrUpdate(Product p);

}
