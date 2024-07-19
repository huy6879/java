/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mua88.controllers;

import com.mua88.services.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author MSI VN
 */
@Controller
public class IndexController {
    private CategoryService cateService;
    
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("categories", this.cateService.getCates());
        return "index";
    }
}