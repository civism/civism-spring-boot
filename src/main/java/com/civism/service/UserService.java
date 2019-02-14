package com.civism.service;

import com.civism.model.UserDo;

/**
 * @author star
 * @date 2019-02-13 13:59
 */
public interface UserService {
    UserDo load(Integer id);
}
