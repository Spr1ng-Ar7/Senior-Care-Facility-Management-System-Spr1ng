package com.cqupt.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cqupt.dto.UserDTO;
import com.cqupt.pojo.User;
import com.cqupt.service.UserService;
import com.cqupt.utils.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "用户管理")
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    @ApiOperation("用户登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String",name="username",value="用户登录账号",required = true),
            @ApiImplicitParam(dataType = "String",name="password",value="用户登录密码",required = true)
    })
    public ResultVo<User> login(String username, String password) throws Exception {
        return userService.login(username, password);
    }

    @GetMapping("/findUserPage")
    @ApiOperation("查询系统用户-分页")
    public ResultVo<Page<User>> findUserPage(UserDTO userDTO) throws Exception {
        return userService.findUserPage(userDTO);
    }

    @GetMapping("/findAllUserPage")
    @ApiOperation("查询全部用户-分页")
    public ResultVo<Page<User>> findAllUserPage(UserDTO userDTO) throws Exception {
        return userService.findAllUserPage(userDTO);
    }

    @PostMapping("/addUser")
    @ApiOperation("添加用户")
    public ResultVo addUser(User user) throws Exception {
        return userService.addUser(user);
    }

    @PutMapping("/updateUser")
    @ApiOperation("修改用户")
    public ResultVo updateUser(User user) throws Exception {
        return userService.updateUser(user);
    }

    @GetMapping("/delUser")
    @ApiOperation("删除用户")
    public ResultVo delUser(Integer id) throws Exception {
        userService.removeById(id);
        return ResultVo.ok("删除成功");
    }

}
