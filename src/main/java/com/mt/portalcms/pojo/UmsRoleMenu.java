package com.mt.portalcms.pojo;

import javax.persistence.*;

@Table(name = "ums_role_menu")
public class UmsRoleMenu {
    /**
     * 角色id
     */
    @Column(name = "role_id")
    private Long roleId;

    /**
     * 菜单id
     */
    @Column(name = "mene_id")
    private Long meneId;

    /**
     * 获取角色id
     *
     * @return role_id - 角色id
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * 设置角色id
     *
     * @param roleId 角色id
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取菜单id
     *
     * @return mene_id - 菜单id
     */
    public Long getMeneId() {
        return meneId;
    }

    /**
     * 设置菜单id
     *
     * @param meneId 菜单id
     */
    public void setMeneId(Long meneId) {
        this.meneId = meneId;
    }
}