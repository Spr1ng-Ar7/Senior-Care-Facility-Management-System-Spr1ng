package com.cqupt.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@ApiModel(value="CustomerPreferenceVo",description="客户喜好")
public class CustomerPreferenceVo {
    @ApiModelProperty(value = "喜好ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "顾客ID")
    private Integer customerId;

    @ApiModelProperty(value = "饮食喜好")
    private String preferences;

    @ApiModelProperty(value = "注意事项")
    private String attention;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "逻辑删除标记")
    private Integer isDeleted;

    //customer
    @ApiModelProperty(value = "顾客姓名")
    private String customerName;

    @ApiModelProperty(value = "顾客年龄")
    private Integer customerAge;

    @ApiModelProperty(value = "顾客性别")
    private Integer customerSex;

}
