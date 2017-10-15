package com.twjitm.menu.service.Impl;


import com.twjitm.menu.dao.MenuDao;
import com.twjitm.menu.dao.PowerDao;
import com.twjitm.menu.entity.Menu;
import com.twjitm.menu.entity.Power;
import com.twjitm.menu.service.IMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * 菜单管理
 *
 * @author 文江
 */
@Service
public class MenuService implements IMenuService {
    @Resource
    private MenuDao menuDao;
    @Resource
    private PowerDao powerDao;

    public List<Menu> getMenuByuserType(Integer uType) {
        List<Power> powers = powerDao.getPowerByuserType(uType);
        if (powers == null || powers.size() == 0) return null;
        Integer[] ids = new Integer[powers.size()];
        for (int i = 0; i < powers.size(); i++) {
            ids[i] = powers.get(i).getMenuId();
        }
        List<Menu> firstMenu = menuDao.getFirstMenus(ids);//first
        for (int i = 0; i < firstMenu.size(); i++) {
            List<Menu> chilMenu = menuDao.getMenuByParentId(firstMenu.get(i).getId());
            firstMenu.get(i).setMenus(chilMenu);
        }

        return firstMenu;
    }


}
