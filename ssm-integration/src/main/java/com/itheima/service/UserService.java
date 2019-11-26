package com.itheima.service;

import com.itheima.domain.PageBean;
import com.itheima.pojo.User;

import java.util.List;

/**
 * 用户的业务接口
 */
public interface UserService {
    /**
     * 查询所有用户
     * @return
     */
   PageBean<User> findAll(Integer currentPage, Integer pageSize, User user);

    /**
     * 添加用户数据
     * @param user
     */
   void add(User user);

    /**
     * 删除数据
     * @param id
     */
    void delete(Integer id);

    /**
     *进行修改之前需要按照修改的用户ID进行查询,数据回显
     * @param id
     * @return
     */
    User findById(Integer id);

    /**
     * 修改用户信息
     * @param user
     */
    void update(User user);

    /**
     * 删除多个选中的用户
     * @param ids
     * @return
     */
    void delSelected(Integer[] ids);
}
