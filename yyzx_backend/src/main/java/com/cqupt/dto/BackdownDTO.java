package com.cqupt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper=false)
@ApiModel(value="BackdownDTO",description="BackdownDTO")
public class BackdownDTO {
    @ApiModelProperty(value = "页码")
    private Integer pageSize;

    @ApiModelProperty(value = "用户id")
    private Integer userId;


}


