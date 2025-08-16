package com.cqupt.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cqupt.dto.BedDetailsDTO;
import com.cqupt.dto.ExchangeDTO;
import com.cqupt.pojo.BedDetails;
import com.cqupt.service.BedDetailsService;
import com.cqupt.utils.ResultVo;
import com.cqupt.vo.BedDetailsVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/beddetails")
@CrossOrigin
@Api(tags = "床位详情管理")
public class BedDetailsController {
    @Autowired
    private BedDetailsService bedDetailsService;

    @GetMapping("/listBedDetailsVoPage")
    @ApiOperation("床位的详情列表动态分页查询")
    public ResultVo<Page<BedDetailsVo>> ListBedDetailsVoPage(BedDetailsDTO bedDetailsDTO)throws Exception{
        return bedDetailsService.ListBedDetailsVoPage(bedDetailsDTO);
    }

    @PostMapping("/updateBedDetails")
    @ApiOperation("修改床位详情信息-只能修改床位的结束时间")
    public ResultVo updateBedDetails(BedDetails bedDetails){
        bedDetailsService.updateById(bedDetails);
        return ResultVo.ok("修改成功");
    }

    @GetMapping("delBedDetails")
    @ApiOperation("删除床位详情信息")
    public ResultVo delBedDetails(Integer id)throws Exception {
        bedDetailsService.removeById(id);
        return ResultVo.ok("删除成功");
    }

    @PostMapping("/exchangeBed")
    @ApiOperation("交换床位")
    public ResultVo exchangeBed(ExchangeDTO exchangeDTO)throws Exception{
        return bedDetailsService.exchangeBed(exchangeDTO);
    }


}
