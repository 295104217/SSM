package com.itheima.controller;

import com.itheima.pojo.Province;
import com.itheima.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/province")
public class ProvinceConreoller {
    @Autowired
    ProvinceService provinceService;


    @RequestMapping("/findAll")
    @ResponseBody
    public List<Province> findAll(Model model){


        return  provinceService.findAll();
    }
}
