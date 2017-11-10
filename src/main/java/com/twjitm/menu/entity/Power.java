package com.twjitm.menu.entity;

public class Power {
    private Integer id;
    private Integer menuId;
    private Integer userType;

    public Integer getId() {
        return this.id;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
