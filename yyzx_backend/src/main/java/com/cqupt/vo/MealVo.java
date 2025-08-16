package com.cqupt.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper=false)
@ApiModel(value="MealVo",description="退住登记")
public class MealVo {

    @ApiModelProperty(value = "饮食ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "星期几")
    private String weekDay;

    @ApiModelProperty(value = "食品ID")
    private Integer foodId;

    @ApiModelProperty(value = "食品类型（1.早餐、2.午餐、3.晚餐）")
    private Integer mealType;

    @ApiModelProperty(value = "口味（多糖、多盐、少糖、少盐）")
    private String taste;

    @ApiModelProperty(value = "逻辑删除标记")
    private Integer isDeleted;

    //food
    @ApiModelProperty(value = "食品名称")
    private String foodName;

    @ApiModelProperty(value = "食品类型")
    private String foodType;

    @ApiModelProperty(value = "价格")
    private BigDecimal price;

    @ApiModelProperty(value = "是否清真")
    private Integer isHalal;

    @ApiModelProperty(value = "图片路径")
    private String foodImg;


}
