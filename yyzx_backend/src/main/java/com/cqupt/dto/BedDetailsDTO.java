package com.cqupt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper=false)
@ApiModel(value="BedDetailsDTO-用户查询的条件",description="BedDetailsDTO")
public class BedDetailsDTO {
    @ApiModelProperty(value = "页码")
    private Integer pageSize;

    @ApiModelProperty(value = "客户姓名")
    private String customerName;

    @ApiModelProperty(value = "查询类型 0-生效床位信息 1- 失效床位信息（历史记录）")
    private Integer isDeleted;

    @ApiModelProperty(value = "开始时间")
    private Date startDate;

    @ApiModelProperty(value = "结束时间")
    private Date endDate;

}
