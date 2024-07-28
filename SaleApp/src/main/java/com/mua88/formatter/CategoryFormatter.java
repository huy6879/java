/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mua88.formatter;

import com.mua88.pojo.Category;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author MSI VN
 */
public class CategoryFormatter implements Formatter<Category>{

    @Override //Từ java đổ ra ngoài template
    public String print(Category cate, Locale locale) {
        return String.valueOf(cate.getId());
    }

    @Override // ĐÓng gói từ template đổ về java thành đối tượng
    public Category parse(String cateId, Locale locale) throws ParseException {
        Category c = new Category();
        c.setId(Integer.parseInt(cateId));
        return c;
    }
    
}
