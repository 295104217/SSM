package com.itheima.controller;

import com.itheima.pojo.Item;
import com.itheima.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemService itemService;

    @RequestMapping("/findById")
    public String findById(Integer id, Model model){
        Item item = itemService.findById(3);
        model.addAttribute("item",item);
        return "item";
    }
}
