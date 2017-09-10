package com.twjitm.user.dao;

import com.twjitm.user.entity.User;
import org.springframework.stereotype.Repository;

import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * Created by Administrator on 2017/8/26.
 */
@Repository
public interface IUserDao {
    public List<User> getAllUser();

    public User getUserById(int Id);

    public List<User> getUsersByTop(int top);

    public void updateser(User user);

    public void updateUsers(List<SOAPBinding.Use> list);

    public void deleteser(int id);

    public void deleteUsers(List<Integer> uIds);

    public void addUser(User user);
}
