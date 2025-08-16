package com.cqupt.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cqupt.dto.NurseItemDTO;
import com.cqupt.pojo.NurseContent;
import com.cqupt.service.NurseContentService;
import com.cqupt.utils.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/nursecontent")
@CrossOrigin
@Api(tags = "护理项目管理")
public class NurseContentController {
    @Autowired
    private NurseContentService nurseContentService;

    @PostMapping("/addNurseItem")
    @ApiOperation("添加护理项目")
    public ResultVo addNurseItem(NurseContent nurseContent) throws Exception {

        nurseContentService.addNurseItem(nurseContent);
        return ResultVo.ok("添加成功");
    }

    @ApiOperation("查询护理项目-分页")
    @GetMapping("/findNurseItemPage")
    public ResultVo<Page<NurseContent>> findNurseItemPage(NurseItemDTO nurseItemDTO) throws Exception {
        return nurseContentService.listNurseContentByPage(nurseItemDTO);
    }

    @ApiOperation("修改护理项目")
    @PostMapping("/updateNurseItem")
    public ResultVo updateNurseItem(NurseContent nurseContent) throws Exception {
        nurseContentService.updateNurseItem(nurseContent);
        return ResultVo.ok("修改成功");
    }

    @ApiOperation("删除护理项目")
    @GetMapping("/delNurseItem")
    public ResultVo delNurseItem(Integer id) throws Exception {
        nurseContentService.delNurseItem(id);
        return ResultVo.ok("删除成功");
    }
}
