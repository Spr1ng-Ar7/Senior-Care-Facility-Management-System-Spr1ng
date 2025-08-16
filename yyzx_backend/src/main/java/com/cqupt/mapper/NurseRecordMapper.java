package com.cqupt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cqupt.pojo.NurseRecord;
import com.cqupt.vo.MealVo;
import com.cqupt.vo.NurseRecordsVo;
import org.apache.ibatis.annotations.Param;

public interface NurseRecordMapper extends BaseMapper<NurseRecord> {
    Page<NurseRecordsVo> selectNurseRecordsVo(@Param("page") Page<NurseRecordsVo> page,
                                             @Param("customerId") Integer customerId)throws Exception;
}
