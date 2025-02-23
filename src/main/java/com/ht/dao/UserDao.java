package com.ht.dao;


import com.ht.model.UserDomain;

import java.util.List;

public interface UserDao {


    int insert(UserDomain record);


    List<UserDomain> selectUsers();

    int del(Integer userId);
    int update(UserDomain record);
}