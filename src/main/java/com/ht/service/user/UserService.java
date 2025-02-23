package com.ht.service.user;

import com.github.pagehelper.PageInfo;
import com.ht.model.UserDomain;

/**
 * Created by  ice
 */
public interface UserService {

    int addUser(UserDomain user);

    PageInfo<UserDomain> findAllUser(int pageNum, int pageSize);

    int delUser(Integer userId);

    int updateUser(UserDomain user);
}

