package com.mt.portalcms.service;

import com.mt.portalcms.pojo.CmsArticleContent;

public interface ICmsArticleContentService {
    CmsArticleContent findByArticleId(Long id);

    CmsArticleContent findByArticleContentId(Long id);

    Integer updateArticleContent(CmsArticleContent cmsArticleContent);

    Integer insertArticleContent(CmsArticleContent cmsArticleContent);

    Integer deleteArticleContent(Long id);


}
