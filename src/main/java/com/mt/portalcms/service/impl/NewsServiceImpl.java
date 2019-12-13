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

import java.util.ArrayList;
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
    public List<CmsArticle> findById(Long id,Long topicId) {
        //将所有新闻和动态id存起来
        List<Long> list=new ArrayList<>();
        Example example = new Example(CmsArticle.class);
        example.createCriteria().andEqualTo("topicId",topicId).andEqualTo("deleted",0).andEqualTo("status",0);
        example.orderBy("createTime").desc();
        List<CmsArticle> cmsArticles = cmsArticleMapper.selectByExample(example);
        for (CmsArticle Article :cmsArticles){
            list.add(Article.getId());
        }
        List<Long> ids=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            if(id==list.get(i)){
                //如果为第一条则没有上一条
                if(i==0){
                    ids.add(list.get(i));
                    ids.add(list.get(i+1));
                }else if(i==list.size()-1){//为最后一条就没有下一条
                    ids.add(list.get(i-1));
                    ids.add(list.get(i));
                }else {
                    ids.add(list.get(i-1));
                    ids.add(list.get(i));
                    ids.add(list.get(i+1));
                }

            }
        }
        List<CmsArticle> articleList = cmsArticleMapper.selectByIdList(ids);
        for (CmsArticle article : articleList){
            CmsArticleContent cmsArticleContent=new CmsArticleContent();
            cmsArticleContent.setArticleId(article.getId());
            CmsArticleContent cmsArticleContent1 = cmsArticleContentMapper.selectOne(cmsArticleContent);
            article.setCmsArticleContents(cmsArticleContent1);
        }

        List<CmsArticle> cmsArticleList=new ArrayList<>();
        for (int i=0;i<list.size();i++){
            if(id==list.get(i)){
                if(i==0){
                    cmsArticleList.add(null);
                    cmsArticleList.add(articleList.get(0));
                    cmsArticleList.add(articleList.get(1));
                }else if(i==list.size()-1){
                    cmsArticleList.add(articleList.get(0));
                    cmsArticleList.add(articleList.get(1));
                    cmsArticleList.add(null);
                }else {
                    return articleList;
                }
            }
        }
        return cmsArticleList;

    }
}
