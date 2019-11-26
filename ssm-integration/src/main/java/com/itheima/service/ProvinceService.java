package com.itheima.service;

import com.itheima.pojo.Province;

import java.util.List;

public interface ProvinceService {

    /**
     * 查询所有省份
     * @return
     */
    public List<Province> findAll();
}
