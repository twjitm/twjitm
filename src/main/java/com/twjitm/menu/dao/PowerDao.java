package com.twjitm.menu.dao;

import com.twjitm.menu.entity.Power;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PowerDao {
    /**
     * 根据用户类型获取用户的那些菜单
     *
     * @param type
     * @return
     */
    public List<Power> getPowerByuserType(Integer type);

}
