package com.boot.datamybatis.service;

import com.boot.datamybatis.mapper.AddressMapper;
import com.boot.datamybatis.model.Address;
import com.boot.datamybatis.model.AddressExample;
import com.boot.datamybatis.model.PageBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: 刘贵龙
 * @Date: 2018/12/23 0023 16:22
 * @Description:
 */
@Service
public class addressService {

    @Resource
    private AddressMapper addressMapper;


    public PageInfo<Address> findItemByPage(int currentPage, int pageSize) {
        //设置分页信息，分别是当前页数和每页显示的总记录数【记住：必须在mapper接口中的方法执行之前设置该分页信息】
        PageHelper.startPage(currentPage, pageSize);
        List<Address> allItems = addressMapper.queryAddress();      //全部商品
        // 封装分页之后的数据  limit
        PageInfo<Address> p=new PageInfo<Address>(allItems);
        System.out.println(p.getPageSize());
        return  p;
    }

}
