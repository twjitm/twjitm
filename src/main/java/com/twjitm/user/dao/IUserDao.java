package com.twjitm.user.dao;

import com.twjitm.user.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/8/26.
 */
@Repository
public interface IUserDao {
    public List<User> getAllUser();
}
