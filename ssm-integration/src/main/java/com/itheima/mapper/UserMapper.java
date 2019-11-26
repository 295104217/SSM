package com.itheima.mapper;

import com.itheima.pojo.User;

import java.util.List;

public interface UserMapper {

    List<User> findAll(User params);

    void add(User user);

    void delete(Integer id);

    User findById(Integer id);

    void update(User user);

    void delSelected(Integer ids);
}
