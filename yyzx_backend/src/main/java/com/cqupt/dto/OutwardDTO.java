package com.cqupt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper=false)
@ApiModel(value="OutwardDTO",description="OutwardDTO")
public class OutwardDTO {
    @ApiModelProperty(value = "用户编号")
    private Integer userId;

    @ApiModelProperty(value = "页码")
    private Integer pageSize;
}
