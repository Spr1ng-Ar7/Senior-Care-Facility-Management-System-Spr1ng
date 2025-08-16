package com.cqupt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cqupt.pojo.Outward;
import com.cqupt.vo.OutwardVo;
import org.apache.ibatis.annotations.Param;

public interface OutwardMapper extends BaseMapper<Outward> {
    Page<OutwardVo> selectOutwardVo(@Param("page") Page<OutwardVo> page,
                                    @Param("userId") Integer userId)throws Exception;
}
