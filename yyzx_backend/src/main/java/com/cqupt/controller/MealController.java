package com.cqupt.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cqupt.dto.MealDTO;
import com.cqupt.pojo.Meal;
import com.cqupt.service.MealService;
import com.cqupt.utils.ResultVo;
import com.cqupt.vo.MealVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/meal")
@CrossOrigin
@Api(tags = "膳食日历管理")
public class MealController {
    @Autowired
    private MealService mealService;

    @GetMapping("/listMealPage")
    @ApiOperation("膳食查询(分页)/可以根据星期查询，根据膳食类型(1.早餐、2.午餐、3.晚餐)")
    public ResultVo<Page<MealVo>> listMealPage(MealDTO mealDto) throws Exception {
        return mealService.listMealVoPage(mealDto);
    }

    @PostMapping("/addMeal")
    @ApiOperation("添加膳食")
    public ResultVo addMeal(Meal meal) throws Exception {
        mealService.save(meal);
        return ResultVo.ok("添加成功");
    }

    @PostMapping("/updateMeal")
    @ApiOperation("更新膳食")
    public ResultVo updateMeal(Meal meal) throws Exception {
        mealService.updateById(meal);
        return ResultVo.ok("更新成功");
    }

    @GetMapping("/removeMeal")
    @ApiOperation("删除膳食")
    public ResultVo removeMeal(Integer id) throws Exception {
        mealService.removeById(id);
        return ResultVo.ok("删除成功");

    }



}
