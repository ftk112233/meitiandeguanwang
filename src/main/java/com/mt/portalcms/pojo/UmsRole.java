package com.mt.portalcms.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import javax.persistence.*;

@Table(name = "ums_role")
public class UmsRole {
    /**
     * 自增主键
     */
    @Id
    private Long id;

    /**
     * 创建人
     */
    @Column(name = "create_by")
    private Long createBy;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新人
     */
    @Column(name = "update_by")
    private Long updateBy;

    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 角色名称
     */
    @Column(name = "role_name")
    private String roleName;

    /**
     * 角色权限字符
     */
    @Column(name = "role_key")
    private String roleKey;

    /**
     * 显示顺序
     */
    private String sort;

    /**
     * 状态 0:正常1:停用
     */
    private Integer status;

    /**
     * 是否删除 0:否1:是
     */
    private Integer deleted;

    /**
     * 获取自增主键
     *
     * @return id - 自增主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置自增主键
     *
     * @param id 自增主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取创建人
     *
     * @return create_by - 创建人
     */
    public Long getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建人
     *
     * @param createBy 创建人
     */
    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新人
     *
     * @return update_by - 更新人
     */
    public Long getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置更新人
     *
     * @param updateBy 更新人
     */
    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取角色名称
     *
     * @return role_name - 角色名称
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 设置角色名称
     *
     * @param roleName 角色名称
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /**
     * 获取角色权限字符
     *
     * @return role_key - 角色权限字符
     */
    public String getRoleKey() {
        return roleKey;
    }

    /**
     * 设置角色权限字符
     *
     * @param roleKey 角色权限字符
     */
    public void setRoleKey(String roleKey) {
        this.roleKey = roleKey == null ? null : roleKey.trim();
    }

    /**
     * 获取显示顺序
     *
     * @return sort - 显示顺序
     */
    public String getSort() {
        return sort;
    }

    /**
     * 设置显示顺序
     *
     * @param sort 显示顺序
     */
    public void setSort(String sort) {
        this.sort = sort == null ? null : sort.trim();
    }

    /**
     * 获取状态 0:正常1:停用
     *
     * @return status - 状态 0:正常1:停用
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态 0:正常1:停用
     *
     * @param status 状态 0:正常1:停用
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取是否删除 0:否1:是
     *
     * @return deleted - 是否删除 0:否1:是
     */
    public Integer getDeleted() {
        return deleted;
    }

    /**
     * 设置是否删除 0:否1:是
     *
     * @param deleted 是否删除 0:否1:是
     */
    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
}