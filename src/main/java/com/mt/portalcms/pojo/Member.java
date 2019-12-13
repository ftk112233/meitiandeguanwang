package com.mt.portalcms.pojo;

import java.util.Date;
import javax.persistence.*;

public class Member {
    /**
     * 成员主键
     */
    @Id
    private Long id;

    /**
     * 成员名称
     */
    private String name;

    /**
     * 性别 0是男 1是女
     */
    private Integer sex;

    /**
     * 部门编号
     */
    @Column(name = "dept_id")
    private Integer deptId;

    /**
     * 出生年月
     */
    private Date birthday;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 更新时间
     */
    private Date updatetime;

    /**
     * 状态 0:正常 1:隐藏
     */
    private Integer status;

    /**
     * 删除 0:否1:是
     */
    private Integer deleted;

    /**
     * 头像图片链接地址
     */
    private String pic;

    /**
     * 照片版式0:竖直1:横排
     */
    @Column(name = "pic_type")
    private Integer picType;

    /**
     * 排在首页的顺序
     */
    @Column(name = "index_sort")
    private Integer indexSort;

    /**
     * 大页面展示0:不展示1:展示
     */
    @Column(name = "index_status")
    private Integer indexStatus;

    /**
     * 成员描述信息
     */
    private String description;

    /**
     * 获取成员主键
     *
     * @return id - 成员主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置成员主键
     *
     * @param id 成员主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取成员名称
     *
     * @return name - 成员名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置成员名称
     *
     * @param name 成员名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取性别 0是男 1是女
     *
     * @return sex - 性别 0是男 1是女
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 设置性别 0是男 1是女
     *
     * @param sex 性别 0是男 1是女
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 获取部门编号
     *
     * @return dept_id - 部门编号
     */
    public Integer getDeptId() {
        return deptId;
    }

    /**
     * 设置部门编号
     *
     * @param deptId 部门编号
     */
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    /**
     * 获取出生年月
     *
     * @return birthday - 出生年月
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 设置出生年月
     *
     * @param birthday 出生年月
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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

    /**
     * 获取创建时间
     *
     * @return createtime - 创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置创建时间
     *
     * @param createtime 创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取更新时间
     *
     * @return updatetime - 更新时间
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * 设置更新时间
     *
     * @param updatetime 更新时间
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * 获取状态 0:正常 1:隐藏
     *
     * @return status - 状态 0:正常 1:隐藏
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态 0:正常 1:隐藏
     *
     * @param status 状态 0:正常 1:隐藏
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取删除 0:否1:是
     *
     * @return deleted - 删除 0:否1:是
     */
    public Integer getDeleted() {
        return deleted;
    }

    /**
     * 设置删除 0:否1:是
     *
     * @param deleted 删除 0:否1:是
     */
    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    /**
     * 获取头像图片链接地址
     *
     * @return pic - 头像图片链接地址
     */
    public String getPic() {
        return pic;
    }

    /**
     * 设置头像图片链接地址
     *
     * @param pic 头像图片链接地址
     */
    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    /**
     * 获取照片版式0:竖直1:横排
     *
     * @return pic_type - 照片版式0:竖直1:横排
     */
    public Integer getPicType() {
        return picType;
    }

    /**
     * 设置照片版式0:竖直1:横排
     *
     * @param picType 照片版式0:竖直1:横排
     */
    public void setPicType(Integer picType) {
        this.picType = picType;
    }

    /**
     * 获取排在首页的顺序
     *
     * @return index_sort - 排在首页的顺序
     */
    public Integer getIndexSort() {
        return indexSort;
    }

    /**
     * 设置排在首页的顺序
     *
     * @param indexSort 排在首页的顺序
     */
    public void setIndexSort(Integer indexSort) {
        this.indexSort = indexSort;
    }

    /**
     * 获取大页面展示0:不展示1:展示
     *
     * @return index_status - 大页面展示0:不展示1:展示
     */
    public Integer getIndexStatus() {
        return indexStatus;
    }

    /**
     * 设置大页面展示0:不展示1:展示
     *
     * @param indexStatus 大页面展示0:不展示1:展示
     */
    public void setIndexStatus(Integer indexStatus) {
        this.indexStatus = indexStatus;
    }

    /**
     * 获取成员描述信息
     *
     * @return description - 成员描述信息
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置成员描述信息
     *
     * @param description 成员描述信息
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}