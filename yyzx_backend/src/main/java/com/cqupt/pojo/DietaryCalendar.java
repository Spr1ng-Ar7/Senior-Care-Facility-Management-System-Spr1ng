package com.cqupt.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.sql.Timestamp;


@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "DietaryCalendar对象", description = "膳食日历表")
public class DietaryCalendar implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "膳食日历ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "膳食编号")
    private Integer dietaryId;

    @ApiModelProperty(value = "早餐中餐晚餐")
    private String dietaryType;

    @ApiModelProperty(value = "星期")
    private String weekDay;

    @ApiModelProperty(value = "口味（多糖、多盐、少糖、少盐）")
    private String taste;

    @ApiModelProperty(value = "创建时间")
    private Timestamp createOn;
}
