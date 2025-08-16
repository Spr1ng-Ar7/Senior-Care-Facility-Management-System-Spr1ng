package com.cqupt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@ApiModel(value="CutomerPreferenceDTO-顾客喜好查询条件",description="CutomerPreferenceDTO")
public class CutomerPreferenceDTO {

    @ApiModelProperty(value = "页码")
    private Integer pageSize;

    @ApiModelProperty(value = "顾客姓名")
    private String customerName;

    @ApiModelProperty(value = "喜好编号")
    private Integer customerPreferenceId;
}
