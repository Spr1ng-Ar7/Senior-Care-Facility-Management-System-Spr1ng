package com.cqupt.controller;

import com.cqupt.pojo.Food;
import com.cqupt.service.FoodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/food")
@CrossOrigin
@Api(tags = "食品管理")
public class FoodController {
    @Autowired
    private FoodService foodService;

    @ApiOperation("查询所有食品列表")
    @GetMapping("/listFood")
    public List<Food> listFood() {
        return foodService.list();
    }
}
