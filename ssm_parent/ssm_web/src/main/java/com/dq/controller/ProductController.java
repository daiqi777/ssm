package com.dq.controller;

import com.dq.domain.Product;
import com.dq.service.ProductService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/test")
    public String test(){
        return "test";
    }

    @RequestMapping(value = "/list")
    public String list(Model model){
        List<Product> productList = productService.list();
        model.addAttribute("productList", productList);
        return "product-list";
    }
/*

    @RequestMapping(value = "/list")
    public String list(@RequestParam(value = "page",required = false,defaultValue = "1")int page,
                       @RequestParam(value = "size",required = false,defaultValue = "5")int size,
                       Model model){
        //集合查询
        PageInfo<Product> pageInfo = productService.pageHelperList(page,size);
        //将数据存入到Model中
        model.addAttribute("pageInfo",pageInfo);
        return "product-list";
    }
*/

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String add(){
        return "product-add";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(Product product){
        //增加数据
        int acount = productService.add(product);
        return "redirect:/product/list";
    }

    @RequestMapping(value = "/update")
    public String update(Product product){
        int count = productService.update(product);
        return "redirect:/product/list";
    }

    @RequestMapping(value = "/one")
    public String getById(Long id,Model model){
        Product product = productService.getById(id);
        model.addAttribute("product",product );
        return "product-update";
    }

    @RequestMapping(value = "/delete")
    public String delete(Integer id){
        int dcount = productService.deleteById(id);
        return "redirect:/product/list";
    }


}
