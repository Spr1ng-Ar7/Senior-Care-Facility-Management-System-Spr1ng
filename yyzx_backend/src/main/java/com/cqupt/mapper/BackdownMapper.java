package com.cqupt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cqupt.dto.BedDetailsDTO;
import com.cqupt.pojo.Backdown;
import com.cqupt.vo.BackdownVo;
import com.cqupt.vo.BedDetailsVo;
import org.apache.ibatis.annotations.Param;

public interface BackdownMapper extends BaseMapper<Backdown> {
    Page<BackdownVo> selectBackdownVo(@Param("page") Page<BackdownVo> page,
                                        @Param("userId") Integer userId);
}
