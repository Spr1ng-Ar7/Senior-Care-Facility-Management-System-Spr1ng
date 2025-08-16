package com.cqupt.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqupt.dto.CustomerNurseItemDTO;
import com.cqupt.mapper.CustomerMapper;
import com.cqupt.mapper.CustomerNurseItemMapper;
import com.cqupt.pojo.Customer;
import com.cqupt.pojo.CustomerNurseItem;
import com.cqupt.service.CustomerNurseItemService;
import com.cqupt.utils.ResultVo;
import com.cqupt.vo.CustomerNurseItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cqupt.utils.DateConverter;
import java.util.Date;
import java.util.List;

@Service
public class CustomerNurseItemServiceImpl extends ServiceImpl<CustomerNurseItemMapper, CustomerNurseItem>implements CustomerNurseItemService {
    @Autowired
    private CustomerNurseItemMapper customerNurseItemMapper;
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public ResultVo<Page<CustomerNurseItemVo>> ListCustomerNurseItemVoPage(CustomerNurseItemDTO customerNurseItemDTO) throws Exception {
        Page<CustomerNurseItemVo> page=new Page<>(customerNurseItemDTO.getPageSize(),6);
        customerNurseItemMapper.selectCustomerNurseItemVo(page,customerNurseItemDTO.getCustomerId());
        return ResultVo.ok(page);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultVo addItemCustomer(List<CustomerNurseItem> customerNurseItems)throws Exception{
        if(customerNurseItems.size()>0){
            //判断选择的是级别中的护理项目还是单独购买的护理项目
            if(customerNurseItems.get(0).getLevelId()!=null){
                //购买级别的护理项目
                Customer customer = new Customer();
                customer.setId(customerNurseItems.get(0).getCustomerId());
                customer.setLevelId(customerNurseItems.get(0).getLevelId());
                int row1=customerMapper.updateById(customer);
                //批量给用户添加护理项目
                boolean flag=saveBatch(customerNurseItems);
                if(row1 <= 0 || !flag){
                    throw new Exception("护理项目配置失败");
                }
            }else{
                //单独购买项目
                saveBatch(customerNurseItems);
            }
            return ResultVo.ok("护理项目添加成功");
        }
        return ResultVo.fail("请选择要添加的护理项目");
    }
    @Override
    public ResultVo removeCustomerLevelAndItem(Integer levelId, Integer customerId)throws Exception{
        //更新客户级别为null
        UpdateWrapper uw1 =new UpdateWrapper();
        uw1.set("level_id",null);
        uw1.eq("id",customerId);
        int row1=customerMapper.update(null,uw1);

        //删除客户当前级别的所有护理项目
        UpdateWrapper uw2 =new UpdateWrapper();
        uw2.set("is_deleted",1);
        uw2.eq("level_id",levelId);
        uw2.eq("custormer_id",customerId);
        int row2=customerNurseItemMapper.update(null,uw2);
        if(!(row1>0&&row2>0)){
            throw new Exception("护理项目配置失败");
        }
        return ResultVo.ok("删除成功");
    }

    @Override
    public ResultVo enewNurseItem (CustomerNurseItem customerNurseItem)throws Exception{
        // 假设续费逻辑是更新服务到期日
        UpdateWrapper<CustomerNurseItem> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", customerNurseItem.getId());
        updateWrapper.set("maturity_time", customerNurseItem.getMaturityTime());
        updateWrapper.set("nurse_number", customerNurseItem.getNurseNumber());
        int row=customerNurseItemMapper.update(null, updateWrapper);
        if(row>0){
            return ResultVo.ok("续费成功");
        }else{
            return ResultVo.fail("续费失败");
        }
    }

    @Override
    public ResultVo isIncludesItemCustomer (Integer customerId,Integer itemId)throws Exception{
        QueryWrapper<CustomerNurseItem> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("custormer_id", customerId);
        queryWrapper.eq("item_id", itemId);
        queryWrapper.eq("is_deleted", 0);
        int row=customerNurseItemMapper.selectCount(queryWrapper);
        if (row > 0) {
            return ResultVo.ok("用户已配置该项目");
        } else {
            return ResultVo.fail("用户未配置该项目");
        }
    }

    @Override
    public ResultVo removeCustomerItem (Integer id)throws Exception{
        UpdateWrapper<CustomerNurseItem> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", id);
        updateWrapper.set("is_deleted", 1);
        int row=customerNurseItemMapper.update(null, updateWrapper);
        if (row > 0) {
            return ResultVo.ok("移除成功");
        } else {
            return ResultVo.fail("移除失败");
        }
    }
}
