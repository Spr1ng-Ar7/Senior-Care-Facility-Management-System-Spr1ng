package com.cqupt.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cqupt.dto.CustomerNurseItemDTO;
import com.cqupt.pojo.CustomerNurseItem;
import com.cqupt.service.CustomerNurseItemService;
import com.cqupt.utils.ResultVo;
import com.cqupt.vo.CustomerNurseItemVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customernurseitem")
@CrossOrigin
@Api(tags = "护理项目")
public class CustomerNurseItemController {
    @Autowired
    private CustomerNurseItemService customerNurseItemService;

    @GetMapping("/listCustomerItem")
    @ApiOperation("查询某个顾客的护理项目列表-分页")
    public ResultVo<Page<CustomerNurseItemVo>> listCustomerItem(CustomerNurseItemDTO customerNurseItemDTO) throws Exception {
        return customerNurseItemService.ListCustomerNurseItemVoPage(customerNurseItemDTO);
    }

    @PostMapping("/addItemToCustomer")
    @ApiOperation("为顾客单个/批量添加护理项目")
    public ResultVo addItemToCustomer (@RequestBody List<CustomerNurseItem> customerNurseItems)throws Exception{
        return customerNurseItemService.addItemCustomer(customerNurseItems);
    }

    @GetMapping("/removeCustomerLevelAndItem")
    @ApiOperation("移除客户护理级别联移除用户当前级别的护理项目")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "int",name="levelId",value="护理级别编号",required = true),
            @ApiImplicitParam(dataType = "int",name="customerId",value="用户编号",required = true)
    })
    public ResultVo removeCustomerLevelAndItem(Integer levelId, Integer customerId)throws Exception{
        return customerNurseItemService.removeCustomerLevelAndItem(levelId,customerId);
    }

    @PostMapping("/enewNurseItem")
    @ApiOperation("客户续费")
    public ResultVo enewNurseItem (CustomerNurseItem customerNurseItem)throws Exception{
        return customerNurseItemService.enewNurseItem(customerNurseItem);

    }

    @GetMapping("/isIncludesItemCustomer")
    @ApiOperation("判断用户是否以及配置了某个指定项目")
    @ApiImplicitParams({

            @ApiImplicitParam(dataType = "int",name="customerId",value="用户编号",required = true),
            @ApiImplicitParam(dataType = "int",name="itemId",value="护理项目编号",required = true)
    })
    public ResultVo isIncludesItemCustomer (Integer customerId,Integer itemId)throws Exception{
        return customerNurseItemService.isIncludesItemCustomer(customerId,itemId);

    }

    @GetMapping("/removeCustomerItem")
    @ApiOperation("移除客户护理项目")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "int",name="id",value="主键key",required = true)
    })
    public ResultVo removeCustomerItem (Integer id)throws Exception{
        return customerNurseItemService.removeCustomerItem(id);

    }
}
