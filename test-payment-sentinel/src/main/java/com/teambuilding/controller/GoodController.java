package com.teambuilding.controller;

import com.teambuilding.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoodController {
    @Autowired
    GoodService goodService;
    @GetMapping("/save")
    public String saveOrder() {
        // 查询商品
        goodService.queryGoods();
        // 查询订单
        System.out.println("新增订单");
        return "新增订单成功";
    }

    @GetMapping("/query")
    public String queryOrder() {
        // 查询商品
        goodService.queryGoods();
        // 查询订单
        System.out.println("查询订单");
        return "查询订单成功";
    }


}
