package com.cqupt.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cqupt.pojo.Bed;
import com.cqupt.service.BedService;
import com.cqupt.utils.ResultVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bed")
@Api(tags = "床位管理") //所有的swagger都在这个标签下
@CrossOrigin //解决跨域问题
public class BedController {
    @Autowired
    private BedService bedService;

    @GetMapping("/findBed")
    public ResultVo<List<Bed>> findBed(Bed bed){
        //创建查询条件包装器
        QueryWrapper<Bed> queryWrapper = new QueryWrapper<>();
        if(bed.getRoomNo() != null){
            queryWrapper.eq("room_no",bed.getRoomNo());
        }
        if(bed.getBedStatus() != null){
            queryWrapper.eq("bed_status",bed.getBedStatus());
        }
        return ResultVo.ok(bedService.list(queryWrapper));
    }


}
