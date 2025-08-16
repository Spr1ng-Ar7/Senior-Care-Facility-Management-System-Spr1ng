package com.cqupt.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cqupt.dto.MealDTO;
import com.cqupt.pojo.Meal;
import com.cqupt.utils.ResultVo;
import com.cqupt.vo.MealVo;

public interface MealService extends IService<Meal> {
    ResultVo<Page<MealVo>> listMealVoPage(MealDTO mealDTO)throws Exception;

}
