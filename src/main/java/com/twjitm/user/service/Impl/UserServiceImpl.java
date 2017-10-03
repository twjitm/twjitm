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
public class UserServiceImpl implements IUserService {
    @Resource
    private IUserDao userDao;

    public List<User> getUser() {
        // User user = userDao.getUserById(1);
        //  System.out.println(user.getEmail() + "-------------------");
        return userDao.getAllUser();
    }

    public User getUserById(int id) {

        return new User();
    }

    public User login(String name, String psd) {
        List<User> list = this.getUser();
        for (User user : list) {
            if (user.getUsername().equals(name) && user.getPassword().equals(psd)) {
                return user;
            }
        }
        return null;
    }

    public void register(User user) {
        List<User> users = this.getUser();
        for (User user1 : users) {
            if (user1.getUsername().equals(user.getUsername())) {
                return;
            }
        }
        userDao.addUser(user);
    }


}
