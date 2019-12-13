package com.mt.portalcms.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import javax.persistence.*;

@Table(name = "cms_column")
public class CmsColumn {
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
     * 栏目名称
     */
    @Column(name = "column_name")
    private String columnName;

    /**
     * 类型id
     */
    @Column(name = "type_id")
    private Long typeId;

    /**
     * 栏目图标
     */
    private String icon;

    /**
     * 上级栏目
     */
    @Column(name = "parent_id")
    private Long parentId;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 状态 0:正常1;隐藏
     */
    private Integer status;

    /**
     * 删除 0:否1:是
     */
    private Integer deleted;

    /**
     * 备注说明
     */
    private String remark;

    /**
     * 栏目链接
     */
    private String url;

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
     * 获取栏目名称
     *
     * @return column_name - 栏目名称
     */
    public String getColumnName() {
        return columnName;
    }

    /**
     * 设置栏目名称
     *
     * @param columnName 栏目名称
     */
    public void setColumnName(String columnName) {
        this.columnName = columnName == null ? null : columnName.trim();
    }

    /**
     * 获取类型id
     *
     * @return type_id - 类型id
     */
    public Long getTypeId() {
        return typeId;
    }

    /**
     * 设置类型id
     *
     * @param typeId 类型id
     */
    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    /**
     * 获取栏目图标
     *
     * @return icon - 栏目图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置栏目图标
     *
     * @param icon 栏目图标
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    /**
     * 获取上级栏目
     *
     * @return parent_id - 上级栏目
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 设置上级栏目
     *
     * @param parentId 上级栏目
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
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
     * 获取状态 0:正常1;隐藏
     *
     * @return status - 状态 0:正常1;隐藏
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态 0:正常1;隐藏
     *
     * @param status 状态 0:正常1;隐藏
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
     * 获取备注说明
     *
     * @return remark - 备注说明
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注说明
     *
     * @param remark 备注说明
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 获取栏目链接
     *
     * @return url - 栏目链接
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置栏目链接
     *
     * @param url 栏目链接
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}