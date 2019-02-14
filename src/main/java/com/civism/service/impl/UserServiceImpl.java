package com.civism.service.impl;

import com.civism.dao.mysql.UserDao;
import com.civism.model.UserDo;
import com.civism.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author star
 * @date 2019-02-13 13:59
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public UserDo load(Integer id) {
        return userDao.load(id);
    }
}
