package com.cqupt.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqupt.dto.UserDTO;
import com.cqupt.mapper.MenuMapper;
import com.cqupt.mapper.RoleMenuMapper;
import com.cqupt.mapper.UserMapper;
import com.cqupt.pojo.Menu;
import com.cqupt.pojo.User;
import com.cqupt.service.UserService;
import com.cqupt.utils.ResultVo;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static com.cqupt.utils.ResultVo.fail;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private final UserMapper userMapper;
    private final RoleMenuMapper roleMenuMapper;
    private final MenuMapper menuMapper;

    public UserServiceImpl(UserMapper userMapper, RoleMenuMapper roleMenuMapper, MenuMapper menuMapper) {
        this.userMapper = userMapper;
        this.roleMenuMapper = roleMenuMapper;
        this.menuMapper = menuMapper;
    }

    @Override
    public ResultVo<User> login(String userName, String Password) throws Exception {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("username", userName);
        qw.eq("password", Password);
        User user = getOne(qw);
        System.out.println(user);
        if (user != null) {
            if (user.getIsDeleted() == 0) {
                QueryWrapper listRoleQw = new QueryWrapper();
                listRoleQw.eq("role_id", user.getRoleId());
                listRoleQw.select("menu");
                List<Integer> menuIds = roleMenuMapper.selectObjs(listRoleQw);
                //
                List<Menu> menus = menuMapper.selectBatchIds(menuIds);
                //
                for (Menu menu : menus) {
                    QueryWrapper listMenuQw = new QueryWrapper();
                    listMenuQw.eq("parent_id", menu.getId());//1
                    menu.setChildren(menuMapper.selectList(listMenuQw));
                }
                user.setMenuList(menus);
                HashMap<String, Object> map = new HashMap<>();
                //
                JwtBuilder builder = Jwts.builder();
                String token = builder.setSubject(userName)
                        .setIssuedAt(new Date())
                        .setId(user.getId().toString())
                        .setClaims(map)
                        .setExpiration(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000))
                        .signWith(SignatureAlgorithm.HS256, "cqupt123456")
                        .compact();
                return ResultVo.ok(user, token);
            }
            return ResultVo.fail("无权限，请联系管理员");
        }
        return ResultVo.fail("账号密码错误");
    }


    @Override
    public ResultVo<Page<User>> findUserPage(UserDTO userDTO) throws Exception {
        Page<User> Mypage = new Page<>(userDTO.getPageSize(), 6);
        QueryWrapper qw= new QueryWrapper();
        if(userDTO.getNickName()!=null&&userDTO.getNickName()!=""){
            qw.like("nickname","%"+ userDTO.getNickName()+"%");

        }
        qw.eq("role_id", userDTO.getRoleId());
        qw.eq("is_deleted", 0);
        page(Mypage,qw);
        return ResultVo.ok(Mypage);
    }

    @Override
    public ResultVo<Page<User>> findAllUserPage(UserDTO userDTO) throws Exception {
        Page<User> page = new Page<>(userDTO.getPageSize(), 6);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (userDTO.getRoleId() != null) {
            queryWrapper.eq("role_id", userDTO.getRoleId());
        }
        if (userDTO.getNickName() != null && !userDTO.getNickName().isEmpty()) {
            queryWrapper.like("nickname", userDTO.getNickName());
        }
        userMapper.selectPage(page, queryWrapper);
        return ResultVo.ok(page);
    }

    @Override
    public ResultVo addUser(User user) throws Exception {
        user.setIsDeleted(0);
        userMapper.insert(user);
        return ResultVo.ok("添加成功");
    }

    @Override
    public ResultVo updateUser(User user) throws Exception {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", user.getId());
        userMapper.update(user, updateWrapper);
        return ResultVo.ok("修改成功");
    }

    @Override
    public ResultVo removeById(Integer id) throws Exception {
        UpdateWrapper updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", id);
        User user = new User();
        user.setIsDeleted(1);
        userMapper.update(user, updateWrapper);
        return ResultVo.ok("用户删除成功");
    }
}
