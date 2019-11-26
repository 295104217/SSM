package com.itheima.service.impl;

import com.itheima.mapper.ItemMapper;
import com.itheima.pojo.Item;
import com.itheima.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("itemService")
public class ItemServiceImpl implements ItemService {

    @Autowired
   private ItemMapper itemMapper;

    /**
     * 按照id查询商品
     *
     * @param id
     * @return
     */
    public Item findById(Integer id) {
        return itemMapper.findById(id);
    }
}
