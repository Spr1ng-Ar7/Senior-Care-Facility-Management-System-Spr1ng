package com.cqupt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cqupt.vo.CustomerNurseItemVo;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: Spr1ng
 * @CreateTime: 2025-06-27 14:30:36
 * @Description: 
 * @Version: 1.0
 */


public interface CustomerNurseItem extends BaseMapper<CustomerNurseItem> {
    int insert(CustomerNurseItem customerNurseItem);

    Page<CustomerNurseItemVo>selectCustomerNurseItemVo(@Param("page")Page<CustomerNurseItemVo>page,
                                                       @Param("customerId") Integer customerId)throws Exception;
}
