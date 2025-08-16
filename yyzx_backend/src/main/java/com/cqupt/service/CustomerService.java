package com.cqupt.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cqupt.dto.KhxxDTO;
import com.cqupt.pojo.Customer;
import com.cqupt.utils.ResultVo;
import com.cqupt.vo.KhxxCustomerVo;

public interface CustomerService extends IService<Customer> {
    //添加客户
    ResultVo addCustomer(Customer customer)throws Exception;
    //分页查询客户信息
    ResultVo<Page<KhxxCustomerVo>> khxxFindCustomer(KhxxDTO khxxDTO)throws Exception;
    //删除客户
    ResultVo removeCustomer(Integer id,Integer bedId)throws Exception;
    //编辑客户
    ResultVo editCustomer(Customer customer)throws Exception;

}
