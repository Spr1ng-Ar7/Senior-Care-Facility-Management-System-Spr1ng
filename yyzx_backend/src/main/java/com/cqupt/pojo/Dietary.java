package com.cqupt.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;


@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Dietary对象", description = "膳食表")
public class Dietary implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "膳食ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "删除标志")
    private Integer isDeleted;

    @ApiModelProperty(value = "膳食类型")
    private String type;

    @ApiModelProperty(value = "膳食名称")
    private String name;

    @ApiModelProperty(value = "价格")
    private BigDecimal price;

    @ApiModelProperty(value = "清真标识")
    private String Islamic;

    @ApiModelProperty(value = "图片")
    private String picture;

    @ApiModelProperty(value = "创建时间")
    private Timestamp createOn;
}
