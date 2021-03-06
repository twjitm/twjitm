package com.twjitm.user.service;

import com.twjitm.user.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2017/8/26.
 */
public interface IUserService {

    public List<User> getUser();

    public User getUserById(int id);

    public User login(String name, String psd);

    public void register(User user);

    public List<User> getUsersByIds(List<Integer> ids);

}
