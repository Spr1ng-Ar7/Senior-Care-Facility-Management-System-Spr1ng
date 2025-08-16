package com.cqupt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@ApiModel(value="MealDTO",description="MealDTO")
public class MealDTO {

    @ApiModelProperty(value = "星期几")
    private String weekDay;

    @ApiModelProperty(value = "食谱编号")
    private Integer mealId;

    @ApiModelProperty(value = "食品类型（1.早餐、2.午餐、3.晚餐）")
    private Integer mealType;

    @ApiModelProperty(value = "页码")
    private Integer pageSize;
}
