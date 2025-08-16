package com.cqupt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqupt.pojo.Bed;
import com.cqupt.vo.CwsyBedVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BedMapper extends BaseMapper<Bed> {
    CwsyBedVo selectBedCount();

}
