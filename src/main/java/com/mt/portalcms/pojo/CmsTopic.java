package com.mt.portalcms.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import javax.persistence.*;

@Table(name = "cms_topic")
public class CmsTopic {
    /**
     * 自增主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 专题名称
     */
    @Column(name = "topic_name")
    private String topicName;

    /**
     * 所属栏目
     */
    @Column(name = "column_id")
    private Long columnId;

    /**
     * 专题图标
     */
    private String icon;

    /**
     * 专题简介
     */
    private String intro;

    /**
     * 状态 0:正常1:隐藏
     */
    private Integer status;

    /**
     * 删除 0:正常1:隐藏
     */
    private Integer deleted;

    /**
     * 专题链接
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
     * 获取专题名称
     *
     * @return topic_name - 专题名称
     */
    public String getTopicName() {
        return topicName;
    }

    /**
     * 设置专题名称
     *
     * @param topicName 专题名称
     */
    public void setTopicName(String topicName) {
        this.topicName = topicName == null ? null : topicName.trim();
    }

    /**
     * 获取所属栏目
     *
     * @return column_id - 所属栏目
     */
    public Long getColumnId() {
        return columnId;
    }

    /**
     * 设置所属栏目
     *
     * @param columnId 所属栏目
     */
    public void setColumnId(Long columnId) {
        this.columnId = columnId;
    }

    /**
     * 获取专题图标
     *
     * @return icon - 专题图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置专题图标
     *
     * @param icon 专题图标
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    /**
     * 获取专题简介
     *
     * @return intro - 专题简介
     */
    public String getIntro() {
        return intro;
    }

    /**
     * 设置专题简介
     *
     * @param intro 专题简介
     */
    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
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
     * 获取删除 0:正常1:隐藏
     *
     * @return deleted - 删除 0:正常1:隐藏
     */
    public Integer getDeleted() {
        return deleted;
    }

    /**
     * 设置删除 0:正常1:隐藏
     *
     * @param deleted 删除 0:正常1:隐藏
     */
    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    /**
     * 获取专题链接
     *
     * @return url - 专题链接
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置专题链接
     *
     * @param url 专题链接
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}