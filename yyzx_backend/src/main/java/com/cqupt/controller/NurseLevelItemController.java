package com.cqupt.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cqupt.pojo.NurseContent;
import com.cqupt.pojo.NurseLevelItem;
import com.cqupt.pojo.Nurselevel;
import com.cqupt.service.NurseContentService;
import com.cqupt.service.NurseLevelItemService;
import com.cqupt.service.NurseLevelService;
import com.cqupt.utils.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/nurseLevelItem")
@Api(tags = "护理项目等级管理")
public class NurseLevelItemController {

    @Autowired
    private NurseLevelService nurseLevelService;
    @Autowired
    private NurseLevelItemService nurseLevelItemService;
    @Autowired
    private NurseContentService nurseContentService;

    @ApiOperation("查询护理级别列表")
    @GetMapping("/listNurseLevel")
    public ResultVo listNurseLevel(Nurselevel nurseLevel) {
        QueryWrapper qw = new QueryWrapper();
        if (nurseLevel.getLevelStatus() != null) {
            qw.like("level_status", nurseLevel.getLevelStatus());
        }
        return ResultVo.ok(nurseLevelService.list(qw));
    }

    @ApiOperation("根据护理级别查询护理项目")
    @GetMapping("/listNurseItemByLevel")
    public ResultVo<List<NurseContent>> listNurseItemByLevel(Integer levelId) throws Exception {
        return nurseContentService.listNurseItemByLevel(levelId);
    }

    @ApiOperation("添加护理项目配置")
    @GetMapping("/addItemToLevel")
    public ResultVo addItemToLevel(NurseLevelItem nurseLevelItem) throws Exception {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("level_id", nurseLevelItem.getLevelId());
        qw.eq("item_id", nurseLevelItem.getItemId());
        int row = nurseLevelItemService.count(qw);
        if (row > 0) {
            return ResultVo.fail("当前级别已存在相同项目");
        }
        nurseLevelItemService.save(nurseLevelItem);
        return ResultVo.ok("添加成功");
    }

    @ApiOperation("删除护理级别中的项目配置")
    @GetMapping("/removeNurseLevelItem")
    public ResultVo removeNurseLevelItem(Integer levelId, Integer itemId) throws Exception {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("level_id", levelId);
        qw.eq("item_id", itemId);
        nurseLevelItemService.remove(qw);
        return ResultVo.ok("删除成功");
    }
}
