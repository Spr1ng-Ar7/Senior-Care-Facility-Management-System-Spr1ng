package com.cqupt.service.Impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqupt.dto.KhxxDTO;
import com.cqupt.mapper.BedDetailsMapper;
import com.cqupt.mapper.BedMapper;
import com.cqupt.mapper.CustomerMapper;
import com.cqupt.pojo.Bed;
import com.cqupt.pojo.BedDetails;
import com.cqupt.pojo.Customer;
import com.cqupt.service.CustomerService;
import com.cqupt.utils.ResultVo;
import com.cqupt.vo.KhxxCustomerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private BedMapper bedMapper;
    @Autowired
    private BedDetailsMapper bedDetailsMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultVo addCustomer(Customer customer) throws Exception {
        //查询床位是否可用 bed
        Bed bed=bedMapper.selectById(customer.getBedId());
        if(bed==null){
            return ResultVo.fail("未找到该床位信息");
        }
        //status: 房间状态 1：空闲 2：有人 3：外出
        if(bed.getBedStatus()!=1){
            return ResultVo.fail("该床位已使用");
        }
        //生成客户信息 customer
        customer.setIsDeleted(0);
        customer.setUserId(-1);
        int row1=customerMapper.insert(customer);
        //生成入住详细信息 beddetails
        BedDetails bedDetails = new BedDetails();
        bedDetails.setCustomerId(customer.getId());//设置客户id
        bedDetails.setIsDeleted(0);//显示
        bedDetails.setBedId(customer.getBedId());//设置床位id
        bedDetails.setStartDate(customer.getCheckinDate());//入住时间
        bedDetails.setEndDate(customer.getExpirationDate());//过期时间
        bedDetails.setBedDetails(customer.getBuildingNo()+'#'+customer.getRoomNo());//床位详情
        int row2 = bedDetailsMapper.insert(bedDetails);
        //修改床位状态 bed
        Bed bed1 =new Bed();
        bed1.setId(customer.getBedId());
        bed1.setBedStatus(2);
        int row3 = bedMapper.updateById(bed1);
        //判断是否入住成功
        if (row1 > 0 && row2 > 0 && row3 > 0) {
            return ResultVo.ok("入住成功");
        }
        throw new Exception("入住失败");
    }
    @Override
    public ResultVo<Page<KhxxCustomerVo>> khxxFindCustomer(KhxxDTO khxxDTO) throws Exception {
        Page<KhxxCustomerVo> page = new Page<>(khxxDTO.getPageSize(),6);
        customerMapper.selectPageVo(page,khxxDTO.getCustomerName(),khxxDTO.getManType(),khxxDTO.getUserId());
        return ResultVo.ok(page);
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultVo removeCustomer(Integer id, Integer bedId) throws Exception {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setIsDeleted(1);
        int row1=customerMapper.updateById(customer);

        BedDetails bedDetails = new BedDetails();
        bedDetails.setIsDeleted(1);
        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.eq("customer_id",id);
        updateWrapper.eq("bed_id",bedId);
        updateWrapper.eq("is_deleted",0);
        int row2=bedDetailsMapper.update(bedDetails,updateWrapper);

        Bed bed = new Bed();
        bed.setId(bedId);
        bed.setBedStatus(1);
        int row3=bedMapper.updateById(bed);
        if(row1>0&&row2>0&&row3>0){
            return ResultVo.ok("删除成功");
        }
        throw new Exception("删除失败");
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultVo editCustomer(Customer customer) throws Exception {
        //1、修改客户信息
        int row1=customerMapper.updateById(customer);

        //2、如果合同到期时间发生改变，更新当前生效床位信息的退住时间为合同到期时间
        if(customer.getExpirationDate()!=null){
            //set
            BedDetails bedDetails = new BedDetails();
            bedDetails.setEndDate(customer.getExpirationDate());
            //where
            UpdateWrapper updateWrapper = new UpdateWrapper();
            updateWrapper.eq("cutomer_id",customer.getId());
            updateWrapper.eq("is_deleted",0);
            int row2=bedDetailsMapper.update(bedDetails,updateWrapper);
            if(!(row1>0&&row2>0)){
                throw new Exception("修改失败");
            }
        }
        return ResultVo.ok("修改成功");

    }

}
