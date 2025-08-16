package com.cqupt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cqupt.pojo.CustomerNurseItem;
import com.cqupt.vo.CustomerNurseItemVo;
import org.apache.ibatis.annotations.Param;

public interface CustomerNurseItemMapper extends BaseMapper<CustomerNurseItem> {
    Page<CustomerNurseItemVo> selectCustomerNurseItemVo(@Param("page") Page<CustomerNurseItemVo> page,
                                                        @Param("customerId") Integer customerId)throws Exception;
}
