package com.cqupt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "顾客数据传输对象")
public class CustomerDTO {
    @ApiModelProperty(value = "ID")
    private Integer id;

    @ApiModelProperty(value = "页码")
    private Integer pageNum;

    @ApiModelProperty(value = "每页记录数")
    private Integer pageSize;

    @ApiModelProperty(value = "顾客姓名")
    private String customerName;

    @ApiModelProperty(value = "顾客年龄")
    private Integer customerAge;

    @ApiModelProperty(value = "顾客性别")
    private String customerSex;

    @ApiModelProperty(value = "床位ID")
    private Integer bedId;

    public Integer getId() {
        return id;
    }

    public Integer getBedId() {
        return bedId;
    }

    public void setBedId(Integer bedId) {
        this.bedId = bedId;
    }
}