package com.cqupt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cqupt.pojo.Meal;
import com.cqupt.vo.MealVo;
import org.apache.ibatis.annotations.Param;

public interface MealMapper extends BaseMapper<Meal> {
    Page<MealVo> selectMealVo(@Param("page") Page<MealVo> page,
                              @Param("weekDay") String weekDay,
                              @Param("mealType") Integer mealType)throws Exception;
}
