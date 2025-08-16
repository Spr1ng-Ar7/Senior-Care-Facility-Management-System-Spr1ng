package com.cqupt.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "CustomerVo对象", description = "顾客管理")
public class CustomerVo {
    @ApiModelProperty(value = "ID")
    private Integer id;

    @ApiModelProperty(value = "逻辑删除标记（0：显示；1：隐藏）")
    private Integer isDeleted;

    @ApiModelProperty(value = "顾客姓名")
    private String customerName;

    @ApiModelProperty(value = "顾客年龄")
    private Integer customerAge;

    @ApiModelProperty(value = "顾客性别")
    private String customerSex;

    @ApiModelProperty(value = "身份证号")
    private String idcard;

    @ApiModelProperty(value = "房间号")
    private String roomNo;

    @ApiModelProperty(value = "楼栋号")
    private String buildingNo;

    @ApiModelProperty(value = "入住日期")
    private Date checkInDate;

    @ApiModelProperty(value = "到期日期")
    private Date expirationDate;

    @ApiModelProperty(value = "联系电话")
    private String contactTel;

    @ApiModelProperty(value = "床位ID")
    private Integer bedId;

    @ApiModelProperty(value = "身心状态")
    private String psychosomaticState;

    @ApiModelProperty(value = "注意事项")
    private String attention;

    @ApiModelProperty(value = "出生日期")
    private Date birthday;

    @ApiModelProperty(value = "身高")
    private Double height;

    @ApiModelProperty(value = "体重")
    private Double weight;

    @ApiModelProperty(value = "血型")
    private String bloodType;

    @ApiModelProperty(value = "头像文件路径")
    private String filepath;

    @ApiModelProperty(value = "健康管家ID")
    private Integer userId;

    @ApiModelProperty(value = "护理等级id")
    private Integer levelId;

    @ApiModelProperty(value = "家庭成员")
    private String familyMember;

    @ApiModelProperty(value = "关联系统健康管家（护工）")
    private String nickName;

    @ApiModelProperty(value = "护理级别")
    private String levelName;

    @ApiModelProperty(value = "床号")
    private String bedNo;
}