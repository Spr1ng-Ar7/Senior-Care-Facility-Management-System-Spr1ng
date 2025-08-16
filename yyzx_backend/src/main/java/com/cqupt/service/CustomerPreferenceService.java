package com.cqupt.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cqupt.dto.CutomerPreferenceDTO;
import com.cqupt.pojo.CustomerPreference;
import com.cqupt.utils.ResultVo;
import com.cqupt.vo.CustomerPreferenceVo;

public interface CustomerPreferenceService extends IService<CustomerPreference> {
    ResultVo<Page<CustomerPreferenceVo>> listCustomerPreferenceVoPage(CutomerPreferenceDTO customerPreferenceDTO)throws Exception;
}
