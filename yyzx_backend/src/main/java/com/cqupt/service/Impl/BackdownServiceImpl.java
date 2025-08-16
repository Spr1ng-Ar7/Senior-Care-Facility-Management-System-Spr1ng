package com.cqupt.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqupt.dto.BackdownDTO;
import com.cqupt.mapper.BackdownMapper;
import com.cqupt.mapper.BedDetailsMapper;
import com.cqupt.mapper.BedMapper;
import com.cqupt.pojo.Backdown;
import com.cqupt.pojo.Bed;
import com.cqupt.pojo.BedDetails;
import com.cqupt.service.BackdownService;
import com.cqupt.utils.ResultVo;
import com.cqupt.vo.BackdownVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BackdownServiceImpl extends ServiceImpl<BackdownMapper, Backdown> implements BackdownService {
    @Autowired
    private BackdownMapper backdownMapper;
    @Autowired
    private BedMapper bedMapper;
    @Autowired
    private BedDetailsMapper bedDetailsMapper;

    @Override
    public ResultVo<Page<BackdownVo>> ListBackdownVo(BackdownDTO backdownDTO) throws Exception {
        Page<BackdownVo> page = new Page<>(backdownDTO.getPageSize(),6);
        backdownMapper.selectBackdownVo(page,backdownDTO.getUserId());
        return ResultVo.ok(page);
    }
    //审批退住申请
    @Override
    public ResultVo examineBackdown(Backdown backdown) throws Exception {

        if(backdown.getAuditstatus()==1){
            QueryWrapper<BedDetails> qw = new QueryWrapper<>();
            Backdown bd = getById(backdown.getId());
            qw.eq("customer_id",bd.getCustomerId());
            BedDetails bedDetails = bedDetailsMapper.selectOne(qw);
            if(bedDetails!=null){
                UpdateWrapper<Bed> uw = new UpdateWrapper<>();
                uw.eq("id",bedDetails.getBedId());
                uw.set("bed_status",1);
                bedMapper.update(null,uw);
            }
        }
        // 更新审批状态、审批时间和审批人
        UpdateWrapper<Backdown> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", backdown.getId());
        updateWrapper.set("auditstatus", backdown.getAuditstatus());
        updateWrapper.set("audittime", backdown.getAudittime());
        updateWrapper.set("auditperson", backdown.getAuditperson());
        int rows = backdownMapper.update(null, updateWrapper);

        if (rows > 0) {
            return ResultVo.ok("审批成功");
        } else {
            throw new Exception("审批失败");
        }
    }
    //撤回退住申请
    @Override
    public ResultVo deleteBackdown(Integer id) throws Exception {
        Backdown backdown = new Backdown();
        backdown.setId(id);
        backdown.setIsDeleted(1);
        boolean result = updateById(backdown);
        if (result) {
            return ResultVo.ok("撤回成功");
        } else {
            throw new Exception("撤回失败");
        }
    }
}
