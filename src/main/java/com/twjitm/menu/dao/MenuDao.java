package com.twjitm.menu.dao;

import com.twjitm.menu.entity.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuDao {
    /**
     * 获取1级菜单
     *
     * @param ids
     * @return
     */
    public List<Menu> getFirstMenus(Integer[] ids);

    /**
     * 获取子菜单
     *
     * @param parentId
     * @return
     */
    public List<Menu> getMenuByParentId(Integer parentId);

    /**
     * 获得所有菜单
     *
     * @return
     */
    public List<Menu> getAllMenus();

}
