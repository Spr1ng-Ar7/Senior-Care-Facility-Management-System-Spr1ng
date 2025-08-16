package com.cqupt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cqupt.dto.BedDetailsDTO;
import com.cqupt.pojo.BedDetails;
import com.cqupt.vo.BedDetailsVo;
import org.apache.ibatis.annotations.Param;

public interface BedDetailsMapper extends BaseMapper<BedDetails> {
    Page<BedDetailsVo> selectBedDetailsVo(@Param("page") Page<BedDetailsVo> page,
                                        @Param("bedDetailsDTO") BedDetailsDTO bedDetailsDTO);
}
