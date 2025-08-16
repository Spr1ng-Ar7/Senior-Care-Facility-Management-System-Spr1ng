package com.cqupt.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cqupt.dto.CutomerPreferenceDTO;
import com.cqupt.dto.KhxxDTO;
import com.cqupt.pojo.CustomerPreference;
import com.cqupt.service.CustomerPreferenceService;
import com.cqupt.utils.ResultVo;
import com.cqupt.vo.CustomerPreferenceVo;
import com.cqupt.vo.KhxxCustomerVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customerpreference")
@CrossOrigin
@Api(tags = "客户偏好")
public class CustomerPreferenceController {
    @Autowired
    private CustomerPreferenceService customerPreferenceService;

    @GetMapping("/listcustomerpreferencepage")
    @ApiOperation("客户偏好动态查询(分页)")
    public ResultVo<Page<CustomerPreferenceVo>> listcustomerpreferencepage(CutomerPreferenceDTO cutomerPreferenceDTO) throws Exception {
        return customerPreferenceService.listCustomerPreferenceVoPage(cutomerPreferenceDTO);
    }

    @PostMapping("/addCustomerPreference")
    @ApiOperation("添加客户偏好")
    public ResultVo addCustomerPreference(CustomerPreference customerPreference)throws Exception {
        customerPreferenceService.save(customerPreference);
        return ResultVo.ok("添加成功");
    }

    @DeleteMapping("/removeCustomerPreference")
    @ApiOperation("删除客户偏好")
    public ResultVo removeCustomerPreference(Integer id)throws Exception {
        customerPreferenceService.removeById(id);
        return ResultVo.ok("删除成功");
    }

    @PutMapping("/updateCustomerPreference")
    @ApiOperation("修改客户偏好")
    public ResultVo updateCustomerPreference(CustomerPreference customerPreference)throws Exception {
        customerPreferenceService.updateById(customerPreference);
        return ResultVo.ok("修改成功");
    }
}
