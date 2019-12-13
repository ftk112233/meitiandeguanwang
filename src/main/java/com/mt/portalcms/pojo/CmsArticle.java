package com.mt.portalcms.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Table(name = "cms_article")
public class CmsArticle {
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
     * 文章标题
     */
    @Column(name = "article_title")
    private String articleTitle;

    /**
     * 所属专题
     */
    @Column(name = "topic_id")
    private Long topicId;

    /**
     * 文章作者
     */
    private String author;

    /**
     * 文章缩略图
     */
    private String pic;

    /**
     * 文章摘要
     */
    @Column(name = "article_abstract")
    private String articleAbstract;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 状态 0:正常1:隐藏
     */
    private Integer status;

    /**
     * 逻辑删除 0:否1:是
     */
    private Integer deleted;
    @Column(name = "english_title")
    private String englishTitle;

    public String getEnglishTitle() {
        return englishTitle;
    }

    public void setEnglishTitle(String englishTitle) {
        this.englishTitle = englishTitle;
    }

    private CmsArticleContent cmsArticleContents;

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
     * 获取文章标题
     *
     * @return article_title - 文章标题
     */
    public String getArticleTitle() {
        return articleTitle;
    }

    /**
     * 设置文章标题
     *
     * @param articleTitle 文章标题
     */
    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle == null ? null : articleTitle.trim();
    }

    /**
     * 获取所属专题
     *
     * @return topic_id - 所属专题
     */
    public Long getTopicId() {
        return topicId;
    }

    /**
     * 设置所属专题
     *
     * @param topicId 所属专题
     */
    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    /**
     * 获取文章作者
     *
     * @return author - 文章作者
     */
    public String getAuthor() {
        return author;
    }

    /**
     * 设置文章作者
     *
     * @param author 文章作者
     */
    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    /**
     * 获取文章缩略图
     *
     * @return pic - 文章缩略图
     */
    public String getPic() {
        return pic;
    }

    /**
     * 设置文章缩略图
     *
     * @param pic 文章缩略图
     */
    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    /**
     * 获取文章摘要
     *
     * @return article_abstract - 文章摘要
     */
    public String getArticleAbstract() {
        return articleAbstract;
    }

    /**
     * 设置文章摘要
     *
     * @param articleAbstract 文章摘要
     */
    public void setArticleAbstract(String articleAbstract) {
        this.articleAbstract = articleAbstract == null ? null : articleAbstract.trim();
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
     * 获取逻辑删除 0:否1:是
     *
     * @return deleted - 逻辑删除 0:否1:是
     */
    public Integer getDeleted() {
        return deleted;
    }

    /**
     * 设置逻辑删除 0:否1:是
     *
     * @param deleted 逻辑删除 0:否1:是
     */
    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public CmsArticleContent getCmsArticleContents() {
        return cmsArticleContents;
    }

    public void setCmsArticleContents(CmsArticleContent cmsArticleContents) {
        this.cmsArticleContents = cmsArticleContents;
    }
}