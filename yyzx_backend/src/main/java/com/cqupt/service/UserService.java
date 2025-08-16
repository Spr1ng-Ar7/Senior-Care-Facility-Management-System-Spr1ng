package com.cqupt.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cqupt.dto.UserDTO;
import com.cqupt.pojo.User;
import com.cqupt.utils.ResultVo;

public interface UserService extends IService<User> {
    ResultVo<User> login(String UserName, String Password)throws Exception;

    ResultVo<Page<User>> findUserPage(UserDTO userDTO)throws Exception;

    ResultVo<Page<User>> findAllUserPage(UserDTO userDTO)throws Exception;


    ResultVo addUser(User user) throws Exception;


    ResultVo updateUser(User user) throws Exception;

    ResultVo removeById(Integer id) throws Exception;
}
