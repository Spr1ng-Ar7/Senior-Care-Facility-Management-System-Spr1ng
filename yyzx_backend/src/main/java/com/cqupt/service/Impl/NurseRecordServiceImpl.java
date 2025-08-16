package com.cqupt.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqupt.dto.NurseRecordDTO;
import com.cqupt.mapper.CustomerNurseItemMapper;
import com.cqupt.mapper.NurseRecordMapper;
import com.cqupt.pojo.CustomerNurseItem;
import com.cqupt.pojo.NurseRecord;
import com.cqupt.service.NurseRecordService;
import com.cqupt.utils.ResultVo;
import com.cqupt.vo.NurseRecordsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NurseRecordServiceImpl extends ServiceImpl<NurseRecordMapper, NurseRecord> implements NurseRecordService{
    @Autowired
    private NurseRecordMapper nurseRecordMapper;
    @Autowired
    private CustomerNurseItemMapper customerNurseItemMapper;

    @Override
    public ResultVo<Page<NurseRecordsVo>> queryNurseRecordsVo (NurseRecordDTO nurseRecordDTO) throws Exception {
        Page<NurseRecordsVo> page =new Page<>(nurseRecordDTO.getPageSize(),6);
        nurseRecordMapper.selectNurseRecordsVo(page,nurseRecordDTO.getCustomerId());
        return ResultVo.ok(page);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultVo addNurseRecord(NurseRecord nurseRecord) throws Exception {
        nurseRecord.setIsDeleted(0);
        boolean temp =save(nurseRecord);
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("item_id",nurseRecord.getItemId());
        queryWrapper.eq("custormer_id",nurseRecord.getCustomerId());
        queryWrapper.eq("is_deleted",0);
        CustomerNurseItem customerNurseItem = customerNurseItemMapper.selectOne(queryWrapper);
        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.set("nurse_number",customerNurseItem.getNurseNumber()-nurseRecord.getNursingCount());
        updateWrapper.eq("item_id",nurseRecord.getItemId());
        updateWrapper.eq("custormer_id",nurseRecord.getCustomerId());
        int row=customerNurseItemMapper.update(null,updateWrapper);
        if(!(temp&&row>0)){
            throw new Exception("护理记录更新失败");
        }
        return ResultVo.ok("护理记录更新成功");

    }
}
