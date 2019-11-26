package com.itheima.service;

import com.itheima.pojo.Item;

public interface ItemService {
    /**
     * 按照id查询商品
     * @param id
     * @return
     */
    Item findById(Integer id);
}
