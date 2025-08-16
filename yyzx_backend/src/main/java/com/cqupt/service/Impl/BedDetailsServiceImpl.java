package com.cqupt.service.Impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqupt.dto.BedDetailsDTO;
import com.cqupt.dto.ExchangeDTO;
import com.cqupt.mapper.BedDetailsMapper;
import com.cqupt.mapper.BedMapper;
import com.cqupt.mapper.CustomerMapper;
import com.cqupt.pojo.Bed;
import com.cqupt.pojo.BedDetails;
import com.cqupt.pojo.Customer;
import com.cqupt.service.BedDetailsService;
import com.cqupt.utils.ResultVo;
import com.cqupt.vo.BedDetailsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class BedDetailsServiceImpl extends ServiceImpl<BedDetailsMapper, BedDetails> implements BedDetailsService {

    @Autowired
    private BedDetailsMapper bedDetailsMapper;
    @Autowired
    private BedMapper bedMapper;
    @Autowired
    private CustomerMapper customerMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultVo exchangeBed(ExchangeDTO exchangeDTO) throws Exception {
        //1、查询床位是否可用
        Bed bed = bedMapper.selectById(exchangeDTO.getNewBedId());
        if (bed == null) {
            return ResultVo.fail("未找到该床位信息");
        }
        //status: 房间状态 1：空闲 2：有人 3：外出
        if(bed.getBedStatus()!=1){
            return ResultVo.fail("该床位已使用");
        }
        // 2、修改客户旧床位的信息(beddetails)，is_deleted = 1，结束的时间设實当前日期
        BedDetails bedDetails =new BedDetails();
        bedDetails.setId(exchangeDTO.getId());
        bedDetails.setIsDeleted(1);
        bedDetails.setEndDate(new Date());
        int row1 =bedDetailsMapper.updateById(bedDetails);
        //3、添加新的床位记录(beddetails)
        BedDetails newBedDetails =new BedDetails();
        newBedDetails.setIsDeleted(0);
        newBedDetails.setCustomerId(exchangeDTO.getCustomerId());
        newBedDetails.setBedId(exchangeDTO.getNewBedId());
        newBedDetails.setStartDate(new Date());
        newBedDetails.setEndDate(exchangeDTO.getEndDate());
        int row2 =bedDetailsMapper.insert(newBedDetails);
        //4、修改旧床位的状态(bed)，status = 1，修改为空闲
        Bed oldBed =new Bed();
        oldBed.setId(exchangeDTO.getOldBedId());
        oldBed.setBedStatus(1);
        int row3 =bedMapper.updateById(oldBed);
        //5、设置新床位位为有人的状态(bed)，status = 2，修改为有人
        Bed newBed =new Bed();
        newBed.setId(exchangeDTO.getNewBedId());
        newBed.setBedStatus(2);
        int row4 =bedMapper.updateById(newBed);
        //6、修改客户的信息(customer)，新的房间号 新床位号 楼号
        Customer customer =new Customer();
        customer.setId(exchangeDTO.getCustomerId());
        customer.setBedId(exchangeDTO.getNewBedId());
        customer.setBuildingNo(exchangeDTO.getBuildingNo());
        customer.setRoomNo(exchangeDTO.getNewRoomNo());
        int row5 =customerMapper.updateById(customer);
        //所有的update都成功执行
        if(row1>0 && row2>0 && row3>0 && row4>0 && row5>0){
            return ResultVo.ok("换房成功");
        }
        throw new Exception("换房失败");
    }


    @Override
    public ResultVo<Page<BedDetailsVo>> ListBedDetailsVoPage(BedDetailsDTO bedDetailsDTO) throws Exception {
        Page<BedDetailsVo> page =new Page<>(bedDetailsDTO.getPageSize(),6);
        bedDetailsMapper.selectBedDetailsVo(page,bedDetailsDTO);
        return ResultVo.ok(page);
    }
}
