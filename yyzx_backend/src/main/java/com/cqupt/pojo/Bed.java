package com.cqupt.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;


@Data
@EqualsAndHashCode(callSuper = false)// 重写equals和hashCode方法，用于比较对象是否相等
@ApiModel(value = "Bed对象", description = "这是bed的实体对象")
public class Bed implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "房间编号")
    @TableField(value = "room_no")
    private Integer roomNo;

    @ApiModelProperty(value = "房间状态 1：空闲  2：有人  3：外出")
    private Integer bedStatus;

    @ApiModelProperty(value = "备注")
    private String remarks;

    @ApiModelProperty(value = "床位编号")
    private String bedNo;

}
