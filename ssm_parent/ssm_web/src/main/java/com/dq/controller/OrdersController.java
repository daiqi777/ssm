package com.dq.controller;

import com.dq.domain.Orders;
import com.dq.domain.Product;
import com.dq.service.OrdersService;
import com.dq.service.ProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/list")
    public String list(@RequestParam(value = "page",required = false,defaultValue = "1")int page,
                       @RequestParam(value = "size",required = false,defaultValue = "4")int size,
                       Model model){
       /* PageHelper.startPage(page, size);*/
        //集合查询
        PageInfo<Orders> pageInfo = ordersService.pageHelperList(page,size);
        //将数据存入到Model中
        model.addAttribute("pageInfo",pageInfo);
        return "order-list";
    }

    /*@RequestMapping(value = "/list")
    public String list(Model model){
        List<Orders> orders = ordersService.list();
        model.addAttribute("orders",orders);
        return "order-list";
    }*/

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String add(Model model){
        List<Product> products = productService.list();
        model.addAttribute("products", products);
        return "order-add";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(Orders orders){
        //增加数据
        int acount = ordersService.add(orders);
        return "redirect:/orders/list";
    }

}
