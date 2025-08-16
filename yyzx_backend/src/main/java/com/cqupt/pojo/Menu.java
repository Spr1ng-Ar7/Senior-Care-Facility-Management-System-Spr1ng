package com.cqupt.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = false)// 重写equals和hashCode方法，用于比较对象是否相等
@ApiModel(value = "Menu对象", description = "这是menu的实体对象")
public class Menu implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "一级菜单索引")
    @TableField(value = "menus_index")
    private String menusIndex;

    @ApiModelProperty(value = "菜单标题")
    private String title;

    @ApiModelProperty(value = "菜单图标")
    private String icon;

    @ApiModelProperty(value = "菜单路径")
    private String path;

    @ApiModelProperty(value = "父级Id")
    private Integer parentId;

    @ApiModelProperty(value = "子菜单")
    @TableField(exist = false) //表示不是数据库的字段
    private List<Menu> children;

}
