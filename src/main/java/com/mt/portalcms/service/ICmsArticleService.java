package com.mt.portalcms.service;

import com.mt.portalcms.common.base.CommonPage;
import com.mt.portalcms.pojo.CmsArticle;
import com.mt.portalcms.pojo.CmsTopic;
import com.mt.portalcms.pojo.vo.CmsArticleVo;

import java.util.List;

public interface ICmsArticleService {
    //管理员查询
    List<CmsArticle> listArticle(Long topicId);

    //门户查询
    List<CmsArticle> selectArticle(Long topicId);

    CmsArticle selectById(Long id);

    Integer insertArticle(CmsArticleVo cmsArticleVo);

    Integer updateArticle(CmsArticleVo cmsArticleVo);


    Integer deleteArticle(Long id);


    Integer findCount(CmsArticle cmsArticle);
}
