package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.domain.PageBean;
import com.itheima.mapper.UserMapper;
import com.itheima.pojo.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户的业务实现
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    /**
     * 查询所有用户
     *
     * @return
     */
    @Autowired
    private UserMapper userMapper;

    public PageBean<User> findAll(Integer currentPage, Integer pageSize, User user) {
        //设置分页参数
        PageHelper.startPage(currentPage, pageSize);
        //创建条件查询给出的User对象
        User paramsUser = new User();
        //判断如果前端给出查询条件,把值封装到条件User对象中
        if (user.getName() != null && user.getName().length() > 0) {
            paramsUser.setName("%" + user.getName() + "%");
        }
        if (user.getAddress() != null && user.getAddress().length() > 0) {
            paramsUser.setAddress(user.getAddress());
        }
        if (user.getEmail() != null && user.getEmail().length() > 0) {
            paramsUser.setEmail("%" + user.getEmail() + "%");
        }
        //进行查询
        Page<User> page = (Page<User>) userMapper.findAll(paramsUser);
        //把数据封装到pageBean中
        PageBean<User> pageBean = new PageBean<User>();
        pageBean.setCurrentPage(page.getPageNum());
        pageBean.setTotalPage(page.getPages());
        pageBean.setTotalCount(Long.valueOf(page.getTotal()).intValue());
        pageBean.setList(page.getResult());
        return pageBean;
    }

    /**
     * 添加用户数据
     *
     * @param user
     */
    public void add(User user) {
        userMapper.add(user);
    }

    /**
     * 删除数据
     *
     * @param id
     */
    public void delete(Integer id) {
        if (id != null && id > 0) {
            userMapper.delete(id);
        }
    }

    /**
     * 进行修改之前需要按照修改的用户ID进行查询,数据回显
     *
     * @param id
     * @return
     */
    public User findById(Integer id) {
        if (id != null && id > 0) {
            User user = userMapper.findById(id);
            return user;
        }
        return null;
    }

    /**
     * 修改用户信息
     *
     * @param user
     */
    public void update(User user) {
        userMapper.update(user);
    }

    /**
     * 删除多个选中的用户
     *
     * @param ids
     * @return
     */
    public void delSelected(Integer[] ids) {
        if (ids != null && ids.length > 0) {
            for (Integer id : ids) {
                userMapper.delSelected(id);
            }
        }
    }
}
