package com.dq.service.impl;

import com.dq.dao.OrdersDao;
import com.dq.domain.Orders;
import com.dq.service.OrdersService;
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
}
