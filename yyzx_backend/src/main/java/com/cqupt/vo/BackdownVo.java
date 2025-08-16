package com.cqupt.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper=false)
@ApiModel(value="BackdownVo",description="退住登记")
public class BackdownVo {
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "备注")
    private String remarks;

    @ApiModelProperty(value = "逻辑删除标记（0：显示；1：隐藏）")
    private Integer isDeleted;

    @ApiModelProperty(value = "客户ID")
    private Integer customerId;

    @ApiModelProperty(value = "退住时间")
    private Date retreattime;

    @ApiModelProperty(value = "退住类型 0-正常退住 1-死亡退住 2-保留床位")
    private Integer retreattype;

    @ApiModelProperty(value = "退住原因")
    private String retreatreason;

    @ApiModelProperty(value = "审批状态 0-已提交 1-同意 2-拒绝")
    private Integer auditstatus;

    @ApiModelProperty(value = "审批人")
    private String auditperson;

    @ApiModelProperty(value = "审批时间")
    private Date audittime;

    //BedDetails
    @ApiModelProperty(value = "床位详情")
    private String bedDetails;

    @ApiModelProperty(value = "床位id")
    private Integer bedId;

    //Customer
    @ApiModelProperty(value = "客户名称")
    private String customerName;
    @ApiModelProperty(value = "入住时间")
    private Date checkinDate;


}
