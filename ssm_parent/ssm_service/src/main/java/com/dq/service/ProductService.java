package com.dq.service;

import com.dq.domain.Product;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ProductService {
    List<Product> list();

    int add(Product product);

    Product getById(Long id);

    int update(Product product);

    int deleteById(Integer id);

    PageInfo<Product> pageHelperList(int page, int size);
}
