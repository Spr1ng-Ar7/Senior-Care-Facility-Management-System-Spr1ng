package com.cqupt.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cqupt.pojo.Room;
import com.cqupt.service.RoomService;
import com.cqupt.utils.ResultVo;
import com.cqupt.vo.CwsyBedVo;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@Api(tags = "房间管理")
@CrossOrigin
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/findCwsyBedVo")
    @ApiOperation("查询床位示意图")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String",name="floor",
                    value="楼层",required = true)
    })
    private ResultVo<CwsyBedVo> findCwsyBedVo (String floor) throws Exception {
        return ResultVo.ok(roomService.findCwsyBedVo(floor));
    }
    @GetMapping("/listRoom")
    @ApiOperation("查询床位列表")
    public ResultVo<List<Room>> listRoom(){
        return ResultVo.ok(roomService.list());
    }
}
