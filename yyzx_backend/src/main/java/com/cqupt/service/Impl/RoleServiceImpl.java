package com.cqupt.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqupt.mapper.RoleMapper;
import com.cqupt.pojo.Role;
import com.cqupt.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
}
