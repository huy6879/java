/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mua88.repositories.impl;

import com.mua88.pojo.Product;
import com.mua88.repositories.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author MSI VN
 */
@Repository
@Transactional
@PropertySource("classpath:configs.properties")
public class ProductRepositoryImpl implements ProductRepository{
    
    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private Environment env;
    
    public List<Product> getProducts(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Product> q = b.createQuery(Product.class);
        Root root = q.from(Product.class);
        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            
            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                predicates.add(b.like(root.get("name"), String.format("%%%s%%", kw)));
            }
            
            String fromPrice = params.get("fromPrice");
            if (fromPrice != null && !fromPrice.isEmpty()) {
                predicates.add(b.greaterThanOrEqualTo(root.get("price"), Double.parseDouble(fromPrice)));
            }
            
            String toPrice = params.get("toPrice");
            if (toPrice != null && !toPrice.isEmpty()) {
                predicates.add(b.lessThanOrEqualTo(root.get("price"), Double.parseDouble(toPrice)));
            }
            
            String cateId = params.get("cateId");
            if (cateId != null && !cateId.isEmpty()) {
                predicates.add(b.equal(root.get("categoryId"), Integer.parseInt(cateId)));
            }
            
            q.where(predicates.toArray(Predicate[]::new));
        }
        q.orderBy(b.desc(root.get("id")));
        Query query = s.createQuery(q);
        
        
        String p = params.get("page");
        if(p != null && !p.isEmpty()){
            int pagesize = Integer.parseInt(env.getProperty("products.pagesize").toString());
            int start = (Integer.parseInt(p) - 1) * pagesize;
            query.setFirstResult(start);
            query.setMaxResults(pagesize);
        }
        
        List<Product> products = query.getResultList();
        
        return products;
    }
    
    public void addOrUpdate(Product p) {
        Session s = this.factory.getObject().getCurrentSession();
        s.saveOrUpdate(p);
    }
}
