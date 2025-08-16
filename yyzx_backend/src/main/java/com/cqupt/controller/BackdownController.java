package com.cqupt.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cqupt.dto.BackdownDTO;
import com.cqupt.dto.BedDetailsDTO;
import com.cqupt.mapper.BedDetailsMapper;
import com.cqupt.mapper.BedMapper;
import com.cqupt.pojo.Backdown;
import com.cqupt.pojo.Bed;
import com.cqupt.pojo.BedDetails;
import com.cqupt.service.BackdownService;
import com.cqupt.utils.ResultVo;
import com.cqupt.vo.BackdownVo;
import com.cqupt.vo.BedDetailsVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/backdown")
@Api(tags = "退住管理")
@CrossOrigin
public class BackdownController {
    @Autowired
    private BackdownService backdownService;
    @Autowired
    private BedMapper bedMapper;

    @Autowired
    private BedDetailsMapper bedDetailsMapper;

    @GetMapping("/listBackdownVo")
    @ApiOperation("床位的详情列表动态分页查询")
    public ResultVo<Page<BackdownVo>> listBackdownVo(BackdownDTO backdownDTO)throws Exception{
        return backdownService.ListBackdownVo(backdownDTO);
    }

    @GetMapping("/examineBackdown")
    @ApiOperation("审批退住登记")
    public ResultVo examineBackdown(Backdown backdown) throws Exception {
        return backdownService.examineBackdown(backdown);
    }
    @GetMapping("/deleteBackdown")
    @ApiOperation("撤回退住登记")
    public ResultVo deleteBackdown(Integer id) throws Exception {
        return backdownService.deleteBackdown(id);
    }

}
