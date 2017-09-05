package com.twjitm.user.service.Impl;

import com.twjitm.user.dao.IUserDao;
import com.twjitm.user.entity.User;
import com.twjitm.user.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/8/26.
 */
@Service("userService")
public class UserServiceImpl implements IUserService{
    @Resource
    private IUserDao userDao;
    public List<User> getUser() {
        return userDao.getAllUser();
    }
}
