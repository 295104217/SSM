package com.itheima.controller;

import com.itheima.domain.PageBean;
import com.itheima.pojo.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 分页查询所有用户
     * @param model
     * @param currentPage
     * @param pageSize
     * @return
     */
    @RequestMapping("/findAll")
    public String findAll(Model model,
                          @RequestParam(value = "currentPage",defaultValue = "1",required = false) Integer currentPage,
                          @RequestParam(value = "pageSize",defaultValue = "5",required = false) Integer pageSize,
                           User user){

        PageBean<User> pageBean = userService.findAll(currentPage,pageSize,user);
        model.addAttribute("pageBean", pageBean);
        return "list";
    }

    /**
     * 点击添加,跳转到添加页面
     * @return
     */
    @RequestMapping("/toAddUI")
    public String toAddUi(){

        return "add";
    }

    /**
     * 添加数据
     * @return
     */
    @RequestMapping("/add")
    public String add(User user, HttpServletRequest request){
        userService.add(user);

        return "redirect:"+request.getContextPath()+"/user/findAll";
    }

    /**
     * 删除用户信息
     * @param id
     * @param request
     * @return
     */
    @RequestMapping("/delete")
    public String delete(Integer id, HttpServletRequest request){

        userService.delete(id);

        return "redirect:"+request.getContextPath()+"/user/findAll";
    }

    /**
     * 进行修改之前需要按照修改的用户ID进行查询,数据回显
     * @param id
     * @return
     */
    @RequestMapping("/findById")
    public String findById(Integer id,Model model){
       User user =  userService.findById(id);
       model.addAttribute("user",user);
       return "update";

    }

    /**
     * 修改用户信息
     * @param user
     * @param request
     * @return
     */
    @RequestMapping("/update")
    public String update(User user ,HttpServletRequest request){
        userService.update(user);
        return "redirect:"+request.getContextPath()+"/user/findAll";
    }

    /**
     * 删除多个选中的用户
     */
    @RequestMapping("/delSelected")
    public String delSelected(Integer[] itemId,HttpServletRequest request){

       userService.delSelected(itemId);
        //重定向到查询页面
        return "redirect:"+request.getContextPath()+"/user/findAll";
    }

}
