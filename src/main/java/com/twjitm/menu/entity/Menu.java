package com.twjitm.menu.entity;

import java.util.List;

/**
 * Menu entity. @author
 */

public class Menu implements java.io.Serializable {

    // Fields

    private Integer id;
    private String menuName;//菜单名字
    private String menuUrl;//功能路径
    private Integer parentId;//父id
    private Integer haveChild;//是否有孩子
    private Integer isHidden;//是否课件
    private Integer orderNum;//排序
    private String menuImg;//菜单图片
    private List<Menu> menus;

    // Constructors

    /**
     * default constructor
     */
    public Menu() {
    }

    /**
     * full constructor
     */
    public Menu(String menuName, String menuUrl, Integer parentId,
                Integer haveChild, Integer isHidden, Integer orderNum) {
        this.menuName = menuName;
        this.menuUrl = menuUrl;
        this.parentId = parentId;
        this.haveChild = haveChild;
        this.isHidden = isHidden;
        this.orderNum = orderNum;
    }

    // Property accessors

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenuName() {
        return this.menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return this.menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public Integer getParentId() {
        return this.parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getHaveChild() {
        return this.haveChild;
    }

    public void setHaveChild(Integer haveChild) {
        this.haveChild = haveChild;
    }

    public Integer getIsHidden() {
        return this.isHidden;
    }

    public void setIsHidden(Integer isHidden) {
        this.isHidden = isHidden;
    }

    public Integer getOrderNum() {
        return this.orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public String getMenuImg() {
        return menuImg;
    }

    public void setMenuImg(String menuImg) {
        this.menuImg = menuImg;
    }


}