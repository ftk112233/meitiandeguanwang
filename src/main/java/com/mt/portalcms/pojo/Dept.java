package com.mt.portalcms.pojo;

import javax.persistence.*;

public class Dept {
    /**
     * 部门id
     */
    @Id
    private Integer id;

    /**
     * 部门名称
     */
    private String name;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 删除
     */
    private Integer deleted;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 获取部门id
     *
     * @return id - 部门id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置部门id
     *
     * @param id 部门id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取部门名称
     *
     * @return name - 部门名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置部门名称
     *
     * @param name 部门名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取状态
     *
     * @return status - 状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态
     *
     * @param status 状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取删除
     *
     * @return deleted - 删除
     */
    public Integer getDeleted() {
        return deleted;
    }

    /**
     * 设置删除
     *
     * @param deleted 删除
     */
    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    /**
     * 获取排序
     *
     * @return sort - 排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序
     *
     * @param sort 排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }
}