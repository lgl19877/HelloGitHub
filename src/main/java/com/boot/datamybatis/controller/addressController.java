package com.boot.datamybatis.controller;

import com.boot.datamybatis.mapper.AddressMapper;
import com.boot.datamybatis.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * http://localhost:9099/updateAddressById?id=1&&contact=张小乐&&addressdesc=北京昌平&&postcode=100000&&tel=18567672312&&createdby=1&&userid=3
 * http://localhost:9099/delAddressById/4
 */
@RestController
public class addressController {

    @Resource
    private AddressMapper addressMapper;

    @GetMapping("/updateAddressById")
    public Address updateAddressById(Address address){
        addressMapper.updateByPrimaryKey(address);
        return  address;
    }

    @GetMapping("/delAddressById/{id}")
        public Long delAddressById(@PathVariable("id") Long id){
        addressMapper.deleteByPrimaryKey(id);
        return id;
    }

}
