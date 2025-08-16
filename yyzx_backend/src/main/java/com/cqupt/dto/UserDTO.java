package com.cqupt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@ApiModel(value="UserDTO-用户查询的条件",description="UserDTO")
public class UserDTO {
    @ApiModelProperty(value = "页码")
    private Integer pageSize;
    @ApiModelProperty(value = "系统角色（1-管理员 2-健康管家）")
    private String roleId;
    @ApiModelProperty(value = "用户真实姓名")
    private String nickName;
}
