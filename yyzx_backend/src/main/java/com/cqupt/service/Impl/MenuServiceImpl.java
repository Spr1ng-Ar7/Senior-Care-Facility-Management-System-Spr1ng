package com.cqupt.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqupt.mapper.MenuMapper;
import com.cqupt.pojo.Menu;
import com.cqupt.service.MenuService;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
}
