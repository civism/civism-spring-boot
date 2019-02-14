package com.civism.dao.mysql;

import com.civism.model.UserDo;

/**
 * @author star
 * @date 2019-02-13 11:48
 */
public interface UserDao {

    UserDo load(Integer id);
}
