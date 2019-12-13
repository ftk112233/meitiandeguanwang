package com.mt.portalcms.pojo;

import java.util.Date;
import javax.persistence.*;

public class Items {
    /**
     * 自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 创建者
     */
    @Column(name = "create_by")
    private String createBy;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新者
     */
    @Column(name = "update_by")
    private String updateBy;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 标题
     */
    @Column(name = "title_name")
    private String titleName;

    /**
     * 英文标题
     */
    @Column(name = "english_title")
    private String englishTitle;

    /**
     * 图片位置
     */
    private String pic;

    /**
     * 描述
     */
    private String description;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 0:开启 1:禁用
     */
    private Integer status;

    /**
     * 0:未删除 1:删除
     */
    private Integer deleted;

    /**
     * 详情图片地址
     */
    @Column(name = "detail_pic")
    private String detailPic;

    /**
     * 英文详情表题
     */
    @Column(name = "english_title_detail")
    private String englishTitleDetail;

    /**
     * 系统介绍
     */
    @Column(name = "sys_desc")
    private String sysDesc;

    /**
     * 运营模式
     */
    private String model;

    /**
     * 获取自增
     *
     * @return id - 自增
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置自增
     *
     * @param id 自增
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取创建者
     *
     * @return create_by - 创建者
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建者
     *
     * @param createBy 创建者
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
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
     * 获取更新者
     *
     * @return update_by - 更新者
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置更新者
     *
     * @param updateBy 更新者
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
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
     * 获取标题
     *
     * @return title_name - 标题
     */
    public String getTitleName() {
        return titleName;
    }

    /**
     * 设置标题
     *
     * @param titleName 标题
     */
    public void setTitleName(String titleName) {
        this.titleName = titleName == null ? null : titleName.trim();
    }

    /**
     * 获取英文标题
     *
     * @return english_title - 英文标题
     */
    public String getEnglishTitle() {
        return englishTitle;
    }

    /**
     * 设置英文标题
     *
     * @param englishTitle 英文标题
     */
    public void setEnglishTitle(String englishTitle) {
        this.englishTitle = englishTitle == null ? null : englishTitle.trim();
    }

    /**
     * 获取图片位置
     *
     * @return pic - 图片位置
     */
    public String getPic() {
        return pic;
    }

    /**
     * 设置图片位置
     *
     * @param pic 图片位置
     */
    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    /**
     * 获取描述
     *
     * @return description - 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置描述
     *
     * @param description 描述
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
     * 获取0:开启 1:禁用
     *
     * @return status - 0:开启 1:禁用
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置0:开启 1:禁用
     *
     * @param status 0:开启 1:禁用
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取0:未删除 1:删除
     *
     * @return deleted - 0:未删除 1:删除
     */
    public Integer getDeleted() {
        return deleted;
    }

    /**
     * 设置0:未删除 1:删除
     *
     * @param deleted 0:未删除 1:删除
     */
    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    /**
     * 获取详情图片地址
     *
     * @return detail_pic - 详情图片地址
     */
    public String getDetailPic() {
        return detailPic;
    }

    /**
     * 设置详情图片地址
     *
     * @param detailPic 详情图片地址
     */
    public void setDetailPic(String detailPic) {
        this.detailPic = detailPic == null ? null : detailPic.trim();
    }

    /**
     * 获取英文详情表题
     *
     * @return english_title_detail - 英文详情表题
     */
    public String getEnglishTitleDetail() {
        return englishTitleDetail;
    }

    /**
     * 设置英文详情表题
     *
     * @param englishTitleDetail 英文详情表题
     */
    public void setEnglishTitleDetail(String englishTitleDetail) {
        this.englishTitleDetail = englishTitleDetail == null ? null : englishTitleDetail.trim();
    }

    /**
     * 获取系统介绍
     *
     * @return sys_desc - 系统介绍
     */
    public String getSysDesc() {
        return sysDesc;
    }

    /**
     * 设置系统介绍
     *
     * @param sysDesc 系统介绍
     */
    public void setSysDesc(String sysDesc) {
        this.sysDesc = sysDesc == null ? null : sysDesc.trim();
    }

    /**
     * 获取运营模式
     *
     * @return model - 运营模式
     */
    public String getModel() {
        return model;
    }

    /**
     * 设置运营模式
     *
     * @param model 运营模式
     */
    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }
}