package com.mt.portalcms.service.impl;

import com.github.pagehelper.PageHelper;
import com.mt.portalcms.common.base.CommonPage;
import com.mt.portalcms.mapper.CmsArticleContentMapper;
import com.mt.portalcms.mapper.CmsArticleMapper;
import com.mt.portalcms.pojo.CmsArticle;
import com.mt.portalcms.pojo.CmsArticleContent;
import com.mt.portalcms.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    CmsArticleMapper cmsArticleMapper;
    @Autowired
    CmsArticleContentMapper cmsArticleContentMapper;

    @Override
    public CommonPage<CmsArticle> list(Integer page, Integer pageSize, Long topicId) {
        PageHelper.startPage(page, pageSize);
        Example example = new Example(CmsArticle.class);
        example.createCriteria().andEqualTo("topicId", topicId).andEqualTo("deleted", 0);
        example.orderBy("createTime").desc();
        List<CmsArticle> cmsArticles = cmsArticleMapper.selectByExample(example);
        for (CmsArticle cmsArticle : cmsArticles) {
            CmsArticleContent cmsArticleContent = new CmsArticleContent();
            cmsArticleContent.setArticleId(cmsArticle.getId());
            CmsArticleContent ArticleContent = cmsArticleContentMapper.selectOne(cmsArticleContent);

            cmsArticle.setCmsArticleContents(ArticleContent);
        }

        return CommonPage.restPage(cmsArticles);
    }

    @Override
    public CommonPage<CmsArticle> select(Integer page, Integer pageSize, Long topicId) {
        PageHelper.startPage(page, pageSize);
        Example example = new Example(CmsArticle.class);
        example.createCriteria().andEqualTo("topicId", topicId).andEqualTo("deleted", 0).andEqualTo("status", 0);
        example.orderBy("createTime").desc();
        List<CmsArticle> cmsArticles = cmsArticleMapper.selectByExample(example);
        for (CmsArticle cmsArticle : cmsArticles) {
            CmsArticleContent cmsArticleContent = new CmsArticleContent();
            cmsArticleContent.setArticleId(cmsArticle.getId());
            CmsArticleContent cmsArticleContent1 = cmsArticleContentMapper.selectOne(cmsArticleContent);
            cmsArticle.setCmsArticleContents(cmsArticleContent1);
        }
        return CommonPage.restPage(cmsArticles);
    }
    @Override
    public CmsArticle findById(Long id) {
        CmsArticle article = cmsArticleMapper.selectByPrimaryKey(id);
        CmsArticleContent cmsArticleContent=new CmsArticleContent();
        cmsArticleContent.setArticleId(id);
        CmsArticleContent cmsArticleContent1 = cmsArticleContentMapper.selectOne(cmsArticleContent);
        article.setCmsArticleContents(cmsArticleContent1);
        return article;

    }
}
