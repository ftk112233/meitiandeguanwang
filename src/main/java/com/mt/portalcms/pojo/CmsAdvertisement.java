package com.mt.portalcms.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Table(name = "cms_advertisement")
public class CmsAdvertisement {
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 广告名称
     */
    @Column(name = "advertise_name")
    private String advertiseName;

    /**
     * 所属广告位
     */
    @Column(name = "type_id")
    private Long typeId;

    /**
     * 链接地址
     */
    private String url;

    /**
     * 广告图片
     */
    private String pic;

    /**
     * 广告描述
     */
    private String description;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 状态 0:正常1:隐藏
     */
    private Integer status;

    /**
     * 删除 0:否1:是
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
     * 获取广告名称
     *
     * @return advertise_name - 广告名称
     */
    public String getAdvertiseName() {
        return advertiseName;
    }

    /**
     * 设置广告名称
     *
     * @param advertiseName 广告名称
     */
    public void setAdvertiseName(String advertiseName) {
        this.advertiseName = advertiseName == null ? null : advertiseName.trim();
    }

    /**
     * 获取所属广告位
     *
     * @return type_id - 所属广告位
     */
    public Long getTypeId() {
        return typeId;
    }

    /**
     * 设置所属广告位
     *
     * @param typeId 所属广告位
     */
    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    /**
     * 获取链接地址
     *
     * @return url - 链接地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置链接地址
     *
     * @param url 链接地址
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 获取广告图片
     *
     * @return pic - 广告图片
     */
    public String getPic() {
        return pic;
    }

    /**
     * 设置广告图片
     *
     * @param pic 广告图片
     */
    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    /**
     * 获取广告描述
     *
     * @return desc - 广告描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置广告描述
     *
     * @param description 广告描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
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
     * 获取状态 0:正常1:隐藏
     *
     * @return status - 状态 0:正常1:隐藏
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态 0:正常1:隐藏
     *
     * @param status 状态 0:正常1:隐藏
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


}