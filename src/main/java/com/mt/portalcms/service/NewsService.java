package com.mt.portalcms.service;

import com.mt.portalcms.common.base.CommonPage;
import com.mt.portalcms.pojo.CmsArticle;
import io.swagger.models.auth.In;

import java.util.List;

public interface NewsService {
    CommonPage<CmsArticle> list(Integer page, Integer pageSize, Long topicId);

    CommonPage<CmsArticle> select(Integer page, Integer pageSize, Long topicId);


    CmsArticle findById(Long id);
}
