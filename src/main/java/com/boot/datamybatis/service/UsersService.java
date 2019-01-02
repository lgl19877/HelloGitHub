package com.boot.datamybatis.service;

import com.boot.datamybatis.model.User;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * @Auther: 刘贵龙
 * @Date: 2018/12/27 0027 14:48
 * @Description:
 */
public interface UsersService {
    List<User> findAll();

    /**
     * 分页查询
     * @param pageNo 页号
     * @param pageSize 每页显示记录数
     * @return
     */
    Page<User> findByPage(int pageNo, int pageSize);

    void insert(User users);
}
