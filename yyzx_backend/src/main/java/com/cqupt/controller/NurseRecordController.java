package com.cqupt.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cqupt.dto.BedDetailsDTO;
import com.cqupt.dto.NurseRecordDTO;
import com.cqupt.dto.OutwardDTO;
import com.cqupt.pojo.NurseRecord;
import com.cqupt.service.BedDetailsService;
import com.cqupt.service.NurseRecordService;
import com.cqupt.service.OutwardService;
import com.cqupt.utils.ResultVo;
import com.cqupt.vo.BedDetailsVo;
import com.cqupt.vo.NurseRecordsVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/nurseRecord")
@Api(tags = "护理记录管理")
public class NurseRecordController {
    @Autowired
    private NurseRecordService nurseRecordService;

    @Autowired
    private OutwardService outwardService;

    @GetMapping("/listNurseRecordsVo")
    @ApiOperation("护理记录列表动态分页查询")
    public ResultVo<Page<NurseRecordsVo>> listNurseRecordVo(NurseRecordDTO nurseRecordDTO)throws Exception{
        return nurseRecordService.queryNurseRecordsVo(nurseRecordDTO);
    }

    @GetMapping("/addNurseRecord")
    @ApiOperation("添加护理记录")
    public ResultVo addNurseRecord(NurseRecord nurseRecord)throws Exception{
        return nurseRecordService.addNurseRecord(nurseRecord);
    }

    @GetMapping("/removeCustomerRecord")
    @ApiOperation("移除护理记录")
    public ResultVo removeCustomerRecord(Integer id)throws Exception{
        NurseRecord nurseRecord = new NurseRecord();
        nurseRecord.setId(id);
        nurseRecord.setIsDeleted(1);
        nurseRecordService.updateById(nurseRecord);
        return ResultVo.ok("移除成功");
    }

    @GetMapping("/queryOutwardVo")
    @ApiOperation("查询外出记录")
    public ResultVo queryOutwardVo(OutwardDTO outwardDTO)throws Exception{
        return outwardService.queryOutwardVo(outwardDTO);
    }




}
