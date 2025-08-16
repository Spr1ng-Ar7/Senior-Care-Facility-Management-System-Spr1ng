package com.cqupt.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cqupt.dto.OutwardDTO;
import com.cqupt.pojo.Outward;
import com.cqupt.service.OutwardService;
import com.cqupt.utils.ResultVo;
import com.cqupt.vo.OutwardVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/outward")
@Api(tags = "外出管理")
public class OutwardController {
    @Autowired
    private OutwardService outwardService;

    @PostMapping("/queryOutwardVo")
    @ApiOperation("查询外出记录")
    public ResultVo queryOutwardVo(OutwardDTO outwardDTO)throws Exception{
        return outwardService.queryOutwardVo(outwardDTO);
    }

    @PostMapping("/addOutward")
    @ApiOperation("添加外出审批")
    public ResultVo addOutward(Outward outward)throws Exception{
        outwardService.save(outward);
        return ResultVo.ok("添加成功");
    }

    @PostMapping("/examineOutward")
    @ApiOperation("审批外出申请")
    public ResultVo examineOutward(Outward outward)throws Exception{
        return outwardService.examineOutward(outward);
    }

    @PostMapping("/delOutward")
    @ApiOperation("撤回外出审批")
    public ResultVo delOutward(Integer id)throws Exception{
        return outwardService.delOutward(id);
    }

    @PostMapping("/updateBackTime")
    @ApiOperation("登记回院时间")
    public ResultVo updateBackTime(Outward outward)throws Exception{
        return outwardService.updateBackTime(outward);
    }
}
