package com.cqupt.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cqupt.dto.BedDetailsDTO;
import com.cqupt.dto.ExchangeDTO;
import com.cqupt.pojo.BedDetails;
import com.cqupt.utils.ResultVo;
import com.cqupt.vo.BedDetailsVo;

public interface BedDetailsService extends IService<BedDetails> {
    //返回分页查询的BedDetailsVo视图
    ResultVo<Page<BedDetailsVo>> ListBedDetailsVoPage(BedDetailsDTO bedDetailsDTO)throws Exception;
    //交换床位
    ResultVo exchangeBed(ExchangeDTO exchangeDTO)throws Exception;
}
