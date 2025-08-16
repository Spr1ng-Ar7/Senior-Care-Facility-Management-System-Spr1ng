package com.cqupt.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Customerpreference对象", description = "客户饮食喜好表")
@TableName("customerpreference")
public class CustomerPreference implements Serializable {
    private static final long serialVersionUID = 1L;

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
}
