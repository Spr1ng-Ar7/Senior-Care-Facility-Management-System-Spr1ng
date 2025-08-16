package com.cqupt.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqupt.mapper.FoodMapper;
import com.cqupt.pojo.Food;
import com.cqupt.service.FoodService;
import org.springframework.stereotype.Service;

@Service
public class FoodServiceImpl extends ServiceImpl<FoodMapper, Food> implements FoodService {
}
