package com.cqupt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: Spr1ng
 * @CreateTime: 2025-06-23 16:02:27
 * @Description: 
 * @Version: 1.0
 */

@Data
@EqualsAndHashCode
@ApiModel(value = "CustomerPreferenceDTO-顾客偏好查询条件",description = "CustomerPreferenceDTO")
public class CustomerPreferenceDTO {
    @ApiModelProperty(value = "喜好编号")
    private Integer id;

    @ApiModelProperty(value = "顾客姓名")
    private String customerName;

    @ApiModelProperty(value = "页码")
    private Integer pageSize;

    @ApiModelProperty(value = "每页数量")
    private Integer pageNum;
}