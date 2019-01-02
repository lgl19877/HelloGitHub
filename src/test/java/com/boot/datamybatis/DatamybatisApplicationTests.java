package com.boot.datamybatis;

import com.boot.datamybatis.mapper.UserMapper;
import com.boot.datamybatis.model.Address;
import com.boot.datamybatis.model.User;
import com.boot.datamybatis.model.UserExample;
import com.boot.datamybatis.service.addressService;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DatamybatisApplicationTests {

    @Resource
    private UserMapper userMapper;

    @Resource
    private addressService addressService;
    @Test
    public void contextLoads() {
        PageInfo<Address> itemByPage = addressService.findItemByPage(1, 2);
        itemByPage.setPages(1);
        itemByPage.setPageSize(1);
        for(Address address:itemByPage.getList()){
            System.out.println(address.getContact());
        }
    }


}
