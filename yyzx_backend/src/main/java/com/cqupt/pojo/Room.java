package com.cqupt.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)// 重写equals和hashCode方法，用于比较对象是否相等
@ApiModel(value = "Room对象", description = "这是room的实体对象")
public class Room implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "房间楼层")
    @TableField(value = "room_floor")
    private String roomFloor;

    @ApiModelProperty(value = "房间编号")
    private Integer roomNo;

    @ApiModelProperty(value = "床位列表")
    @TableField(exist = false)
    private List<Bed> bedList;

}
