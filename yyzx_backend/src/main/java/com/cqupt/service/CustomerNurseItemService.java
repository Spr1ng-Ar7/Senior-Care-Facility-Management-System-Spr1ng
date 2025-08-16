package com.cqupt.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cqupt.dto.BedDetailsDTO;
import com.cqupt.dto.CustomerNurseItemDTO;
import com.cqupt.pojo.CustomerNurseItem;
import com.cqupt.utils.ResultVo;
import com.cqupt.vo.BedDetailsVo;
import com.cqupt.vo.CustomerNurseItemVo;

import java.util.List;

public interface CustomerNurseItemService extends IService<CustomerNurseItem> {
    ResultVo<Page<CustomerNurseItemVo>> ListCustomerNurseItemVoPage(CustomerNurseItemDTO customerNurseItemDTO)throws Exception;

    ResultVo addItemCustomer (List<CustomerNurseItem> customerNurseItems)throws Exception;


    ResultVo removeCustomerLevelAndItem(Integer levelId, Integer customerId)throws Exception;

    ResultVo enewNurseItem (CustomerNurseItem customerNurseItem)throws Exception;

    ResultVo isIncludesItemCustomer (Integer customerId,Integer itemId)throws Exception;

    ResultVo removeCustomerItem (Integer id)throws Exception;
}
