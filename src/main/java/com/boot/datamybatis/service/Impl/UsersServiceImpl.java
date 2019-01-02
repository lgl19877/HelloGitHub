package com.boot.datamybatis.service.Impl;

import com.boot.datamybatis.mapper.UserMapper;
import com.boot.datamybatis.model.User;
import com.boot.datamybatis.service.UsersService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: 刘贵龙
 * @Date: 2018/12/27 0027 14:49
 * @Description:
 */
@Service
public class UsersServiceImpl implements UsersService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsersServiceImpl.class);
    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public Page<User> findByPage(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        Page<User> byPage = userMapper.findByPage();
        LOGGER.info("UsersServicePageSize==>"+byPage.size());
        return byPage;
    }

    /**
     * @Transactional(rollbackFor=Exception.class)
     *  回滚异常 前提是方法中代码不添加try cath
     * @param users
     */
    @Override
    @Transactional(rollbackFor=Exception.class)
    public void insert(User users) {
        userMapper.insert(users);
/*        try {
/*            userMapper.insert(users);*/
/*        } catch (Exception e) {*/
/*          throw new RuntimeException("save 抛异常了");*/
/*        }*/
    }

}
