package com.cqupt.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper=false)
@ApiModel(value="CustomerNurseItemVo",description="客户服务")
public class CustomerNurseItemVo {
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "护理项目编号")
    private Integer itemId;

    @ApiModelProperty(value = "客户编号")
    @TableField(value = "custormer_id")
    private Integer customerId;

    @ApiModelProperty(value = "护理级别编号")
    private Integer levelId;

    @ApiModelProperty(value = "购买数量")
    private Integer nurseNumber;

    @ApiModelProperty(value = "逻辑删除标记（0：显示；1：隐藏）")
    private Integer isDeleted;

    @ApiModelProperty(value = "服务购买日期")
    private Date buyTime;

    @ApiModelProperty(value = "服务到期日")
    private Date maturityTime;

    //customer
    @ApiModelProperty(value = "客户姓名")
    private String customerName;

    //NurseContent
    @ApiModelProperty(value = "编号")
    private String serialNumber;

    @ApiModelProperty(value = "名称")
    private String nursingName;

    @ApiModelProperty(value = "价格")
    private String servicePrice;
}
