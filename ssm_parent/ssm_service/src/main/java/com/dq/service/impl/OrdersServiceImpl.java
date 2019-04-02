package com.dq.service.impl;

import com.dq.dao.OrdersDao;
import com.dq.domain.Orders;
import com.dq.service.OrdersService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("OrdersService")
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersDao ordersDao;

    @Override
    public List<Orders> list() {
        return ordersDao.list();
    }

    @Override
    public int add(Orders orders) {
        return ordersDao.add(orders);
    }

    @Override
    public PageInfo<Orders> pageHelperList(int page, int size) {
        PageHelper.startPage(page,size );
        List<Orders> orders = ordersDao.list();
        return new PageInfo<Orders>(orders);
    }
}
