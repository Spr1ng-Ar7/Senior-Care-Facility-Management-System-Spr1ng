package com.cqupt.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqupt.mapper.BedMapper;
import com.cqupt.mapper.RoomMapper;
import com.cqupt.pojo.Room;
import com.cqupt.service.RoomService;
import com.cqupt.utils.ResultVo;
import com.cqupt.vo.CwsyBedVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl extends ServiceImpl<RoomMapper, Room> implements RoomService {
    @Autowired
    private BedMapper bedMapper;

    @Override
    public ResultVo<CwsyBedVo> findCwsyBedVo(String floor)throws Exception  {
        //统计床位
        CwsyBedVo cwsyBedVo=bedMapper.selectBedCount();
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("room_floor",floor);
        //查询所有的房间
        List<Room> rooms = list(queryWrapper);

        //查询每个房间的床位情况
        for (Room room : rooms) {
            QueryWrapper qwBed = new QueryWrapper();
            qwBed.eq("room_no",room.getRoomNo());
            room.setBedList(bedMapper.selectList(qwBed));
        }
        cwsyBedVo.setRoomList(rooms);
        return ResultVo.ok(cwsyBedVo);



    }
}
