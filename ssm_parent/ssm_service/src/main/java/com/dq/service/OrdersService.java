package com.dq.service;

import com.dq.domain.Orders;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface OrdersService {
    List<Orders> list();

    int add(Orders orders);

    PageInfo<Orders> pageHelperList(int page, int size);
}
