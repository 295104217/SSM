package com.itheima.service.impl;

import com.itheima.mapper.ProvinceMapper;
import com.itheima.pojo.Province;
import com.itheima.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("provinceService")
public class ProvinceServiceImpl implements ProvinceService {
    /**
     * 查询所有省份
     *
     * @return
     */
    @Autowired
    ProvinceMapper provinceMapper;

    public List<Province> findAll() {

        return provinceMapper.findAll();
    }
}
