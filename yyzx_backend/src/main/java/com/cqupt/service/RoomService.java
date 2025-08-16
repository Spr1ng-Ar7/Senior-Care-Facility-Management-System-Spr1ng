package com.cqupt.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cqupt.pojo.Room;
import com.cqupt.utils.ResultVo;
import com.cqupt.vo.CwsyBedVo;

public interface RoomService extends IService<Room> {
    ResultVo<CwsyBedVo> findCwsyBedVo(String floor) throws Exception;

}
