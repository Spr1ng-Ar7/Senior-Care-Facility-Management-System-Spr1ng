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
@ApiModel(value="OutwardVo",description="外出登记")
public class OutwardVo {
    @ApiModelProperty(value = "主键ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "备注")
    private String remarks;

    @ApiModelProperty(value = "逻辑删除标记（0：显示；1：隐藏）")
    private Integer isDeleted;

    @ApiModelProperty(value = "客户ID")
    private Integer customerId;

    @ApiModelProperty(value = "外出事由")
    private String outgoingreason;

    @ApiModelProperty(value = "外出时间")
    private Date outgoingtime;

    @ApiModelProperty(value = "预计回院时间")
    private Date expectedreturntime;

    @ApiModelProperty(value = "实际回院时间")
    private Date actualreturntime;

    @ApiModelProperty(value = "陪同人")
    private String escorted;

    @ApiModelProperty(value = "与老人关系")
    private String relation;

    @ApiModelProperty(value = "陪同人电话")
    private String escortedtel;

    @ApiModelProperty(value = "审批状态  0-已提交 1-同意  2-拒绝")
    private Integer auditstatus;

    @ApiModelProperty(value = "审批人")
    private String auditperson;

    @ApiModelProperty(value = "审批时间")
    private Date audittime;

    //User
    @ApiModelProperty(value = "真实姓名")
    private String nickname;

    @ApiModelProperty(value = "手机号码")
    private String phoneNumber;

    //NurseContent
    @ApiModelProperty(value = "编号")
    private String serialNumber;

    @ApiModelProperty(value = "名称")
    private String nursingName;

    //Customer
    @ApiModelProperty(value = "客户姓名")
    private String customerName;



}
