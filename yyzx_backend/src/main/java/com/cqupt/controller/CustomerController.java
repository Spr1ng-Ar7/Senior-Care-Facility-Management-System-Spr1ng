package com.cqupt.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cqupt.dto.KhxxDTO;
import com.cqupt.pojo.Customer;
import com.cqupt.service.CustomerService;
import com.cqupt.utils.ResultVo;
import com.cqupt.vo.KhxxCustomerVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@CrossOrigin
@Api(tags = "客户管理")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/rzdj")
    @ApiOperation("入住登记")
    public ResultVo addCustomer(Customer customer) throws Exception {
        customerService.addCustomer(customer);
        return ResultVo.ok("登记成功");
    }
    @GetMapping("/listkhxxpage")
    @ApiOperation("客户信息动态查询(分页)")
    public ResultVo<Page<KhxxCustomerVo>> listkhxxpage(KhxxDTO khxxDTO) throws Exception {
        return customerService.khxxFindCustomer(khxxDTO);
    }

    @DeleteMapping("/remove")
    @ApiOperation("根据key删除")
    public ResultVo remove(Integer id,Integer bedId) throws Exception {
        customerService.removeCustomer(id,bedId);
        return ResultVo.ok("删除成功");
    }

    @PutMapping("/editkhxx")
    @ApiOperation("编辑客户信息")
    public ResultVo editCustomer(Customer customer) throws Exception {
        customerService.editCustomer(customer);
        return ResultVo.ok("编辑成功");
    }
}
