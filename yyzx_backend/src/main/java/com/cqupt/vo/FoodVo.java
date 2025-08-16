package com.cqupt.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author Spr1ng
 * @version1 1.0
 */

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "FoodVo对象", description = "食品管理")
public class FoodVo {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "饮食ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "食品ID")
    private Integer foodId;

    @ApiModelProperty(value = "食品类型")
    private String foodType;

    @ApiModelProperty(value = "价格")
    private Double price;

    @ApiModelProperty(value = "是否清真（0：否；1：是）")
    private Integer isHalal;

    @ApiModelProperty(value = "图片路径")
    private String foodImg;
}