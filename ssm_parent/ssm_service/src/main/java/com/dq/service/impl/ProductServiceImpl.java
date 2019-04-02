package com.dq.service.impl;

import com.dq.dao.ProcudtDao;
import com.dq.domain.Product;
import com.dq.service.ProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ProductService")
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProcudtDao productDao;


    @Override
    public List<Product> list() {
        List<Product> productList = productDao.list();
        return productList;
    }

    @Override
    public int add(Product product) {
        int i = productDao.add(product);
        return i;
    }

    @Override
    public Product getById(Long id) {
        return productDao.getById(id);
    }

    @Override
    public int update(Product product) {
        return productDao.update(product);
    }

    @Override
    public int deleteById(Integer id) {
        return productDao.deleteById(id);
    }

    @Override
    public PageInfo<Product> pageHelperList(int page, int size) {
        PageHelper.startPage(page,size);
        List<Product> products = productDao.list();
        return new PageInfo<Product>(products);
    }
}
