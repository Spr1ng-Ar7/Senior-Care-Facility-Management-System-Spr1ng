package com.cqupt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cqupt.pojo.CustomerPreference;
import com.cqupt.vo.CustomerPreferenceVo;
import org.apache.ibatis.annotations.Param;

public interface CustomerPreferenceMapper extends BaseMapper<CustomerPreference> {
    Page<CustomerPreferenceVo> selectCustomerPreferenceVo(@Param("page") Page<CustomerPreferenceVo> page,
                                                          @Param("customerName") String customerName)throws Exception;
}
