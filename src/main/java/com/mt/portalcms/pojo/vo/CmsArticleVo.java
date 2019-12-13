package com.mt.portalcms.pojo.vo;


import com.mt.portalcms.pojo.CmsArticle;

import javax.persistence.Transient;

public class CmsArticleVo extends CmsArticle {
    private Long id;
    private String content;
    private String pic;
    private Long topicId;
    private Integer status;
    private String englishTitle;
    private String articleTitle;
    private String articleAbstract;
    @Transient
    private Long articleId;

    @Override
    public String getArticleAbstract() {
        return articleAbstract;
    }

    @Override
    public void setArticleAbstract(String articleAbstract) {
        this.articleAbstract = articleAbstract;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getEnglishTitle() {
        return englishTitle;
    }

    public void setEnglishTitle(String englishTitle) {
        this.englishTitle = englishTitle;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

}
