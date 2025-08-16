package com.cqupt.service.Impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqupt.dto.OutwardDTO;
import com.cqupt.mapper.OutwardMapper;
import com.cqupt.pojo.Outward;
import com.cqupt.service.OutwardService;
import com.cqupt.utils.ResultVo;
import com.cqupt.vo.OutwardVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OutwardServiceImpl extends ServiceImpl<OutwardMapper, Outward> implements OutwardService  {
    @Autowired
    private OutwardMapper outwardMapper;

    //审批外出
    @Override
    public ResultVo examineOutward(Outward outward) throws Exception {
        UpdateWrapper<Outward> updateWrapper = new UpdateWrapper<Outward>();
        updateWrapper.eq("id", outward.getId());
        updateWrapper.set("audistatus",outward.getAuditstatus());
        outwardMapper.update(null, updateWrapper);
        return ResultVo.ok("审批成功");
    }

    //分页查询
    @Override
    public ResultVo<Page<Outward>> queryOutwardVo(OutwardDTO outwardDTO) throws Exception {
        Page<OutwardVo> page = new Page(outwardDTO.getPageSize(),6);
        outwardMapper.selectOutwardVo(page,outwardDTO.getUserId());
        return ResultVo.ok(page);
    }

    //撤销外出登记
    @Override
    public ResultVo delOutward(Integer id) throws Exception {
        UpdateWrapper<Outward> updateWrapper = new UpdateWrapper<Outward>();
        updateWrapper.eq("id", id);
        updateWrapper.set("is_deleted",1);
        outwardMapper.update(null, updateWrapper);
        return ResultVo.ok("撤销成功");
    }
    //登记回院时间
    @Override
    public ResultVo updateBackTime(Outward outward) throws Exception {
        UpdateWrapper<Outward> updateWrapper = new UpdateWrapper<Outward>();
        updateWrapper.eq("id", outward.getId());
        updateWrapper.set("actualreturntime",outward.getActualreturntime());
        outwardMapper.update(null, updateWrapper);
        return ResultVo.ok("成功登记回院时间");
    }
}
