package com.boot.datamybatis.controller;

import com.boot.datamybatis.mapper.UserMapper;
import com.boot.datamybatis.model.User;
import com.boot.datamybatis.service.UsersService;
import com.github.pagehelper.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * http://localhost:9099/queryById/6
 * http://localhost:9099/addUser?usercode=lixin&&username=李信&&userpassword=0000000&&gender=2
 * http://localhost:9099/page/3/2
 */
@RestController
public class userController {

    private static final Logger LOGGER = LoggerFactory.getLogger(userController.class);
    @Resource
    private UserMapper userMapper;
    @Resource
    private UsersService usersService;

    @GetMapping("/queryById/{id}")
    public User getUserById(@PathVariable("id") Long id){
        return userMapper.selectByPrimaryKey(id);
    }
    @GetMapping("/addUser")
    public User  addUser(User user){
        userMapper.insert(user);
        return user;
    }

    @GetMapping("/queryUser/{id}")
    public User queryUserAndRoleAndAddress(@PathVariable("id") Long id){
        return userMapper.queryUserAndRoleAndAddress(id);
    }

    @RequestMapping("/save")
    public User saveUser(User user){
        usersService.insert(user);
        return user;
    }

    @RequestMapping("/all")
    public List<User> queryAllUser(){
      return usersService.findAll();
    }

    @RequestMapping("/page/{pageNo}/{pageSize}")
    public Page<User> findByPage(@PathVariable("pageNo") int pageNo,@PathVariable("pageSize") int pageSize){
        LOGGER.info("userController接受到pageNo==>"+pageNo+"pageSize==>"+pageSize);
        Page<User> pagePeople =usersService.findByPage(pageNo, pageSize);
        return pagePeople;
    }
}
