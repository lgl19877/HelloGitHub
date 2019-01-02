package com.boot.datamybatis.mapper;

import com.boot.datamybatis.model.User;
import com.boot.datamybatis.model.UserExample;
import java.util.List;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    //三表联查
    User queryUserAndRoleAndAddress(Long id);

    /**
     * 获取所有数据
     * @return
     */
    List<User> findAll();

    /**
     * 分页查询数据
     * @return
     */
    Page<User> findByPage();
}