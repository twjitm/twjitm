package com.twjitm.answer.service;

import com.twjitm.answer.entity.Users;
import com.twjitm.user.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2017/8/26.
 */
public interface IUsersService {

    public List<Users> getUser();

    public Users getUserById(int id);

    public Users login(String name, String psd);

    public void register(Users user);

    public List<Users> getUsersByIds(List<Integer> ids);

}
