package com.dq.service;

import com.dq.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> list();

    int add(Product product);

    Product getById(Long id);

    int update(Product product);

    int deleteById(Integer id);
}
