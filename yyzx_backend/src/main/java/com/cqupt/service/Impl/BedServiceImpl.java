package com.cqupt.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqupt.mapper.BedMapper;
import com.cqupt.pojo.Bed;
import com.cqupt.service.BedService;
import org.springframework.stereotype.Service;

@Service
public class BedServiceImpl extends ServiceImpl<BedMapper, Bed> implements BedService {

}
