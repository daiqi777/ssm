package com.dq.controller;

import com.dq.domain.Orders;
import com.dq.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @RequestMapping(value = "/list")
    public String list(Model model){
        List<Orders> orders = ordersService.list();
        model.addAttribute("orders",orders);
        return "order-list";
    }

}
