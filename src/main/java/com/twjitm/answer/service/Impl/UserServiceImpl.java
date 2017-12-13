package com.twjitm.answer.service.Impl;

import com.twjitm.answer.dao.UsersMapper;
import com.twjitm.answer.entity.Users;
import com.twjitm.answer.service.IUsersService;
import com.twjitm.user.dao.IUserDao;
import com.twjitm.user.entity.User;
import com.twjitm.utils.Md5Utils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/8/26.
 */
@Service("usersService")
public class UserServiceImpl implements IUsersService {
    @Resource
    public UsersMapper usersMapper;

    public List<Users> getUser() {
        // User user = userDao.getUserById(1);
        //  System.out.println(user.getEmail() + "-------------------");
        return usersMapper.getAllUser();
    }

    public Users getUserById(int id) {
        return usersMapper.selectByPrimaryKey(id);

    }

    public Users login(String name, String psd) {
        String md5=Md5Utils.StringToMd5(psd);
        System.out.println(md5);
        Users users= usersMapper.login(name,md5);
        return users;
    }


    public void register(Users user) {
        List<Users> users = this.getUser();
        for (Users user1 : users) {
            if (user1.getuAccount().equals(user.getuAccount())) {
                return;
            }
        }
        usersMapper.insert(user);
    }

    public List<Users> getUsersByIds(List<Integer> ids) {
        return null;
    }


}
