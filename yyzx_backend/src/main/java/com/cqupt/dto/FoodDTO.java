package com.cqupt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@ApiModel(value = "FoodDTO-食品信息查询条件", description = "FoodDTO")
public class FoodDTO {
    @ApiModelProperty(value = "页码")
    private Integer pageNum;

    @ApiModelProperty(value = "每页记录数")
    private Integer pageSize;

    @ApiModelProperty(value = "食品ID")
    private Integer foodId;

    @ApiModelProperty(value = "食品类型")
    private String foodType;

    @ApiModelProperty(value = "是否清真（0：否；1：是）")
    private Integer isHalal;
}