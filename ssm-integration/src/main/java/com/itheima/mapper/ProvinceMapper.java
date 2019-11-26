package com.itheima.mapper;

import com.itheima.pojo.Province;

import java.util.List;

/**
 * 省的接口
 */
public interface ProvinceMapper {


    ProvinceMapper findOne(String code);

    List<Province> findAll();
}
