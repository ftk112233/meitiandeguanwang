package com.mt.portalcms.mapper;

import com.mt.portalcms.common.config.MyMapper;
import com.mt.portalcms.pojo.CmsArticle;
import tk.mybatis.mapper.additional.idlist.IdListMapper;

public interface CmsArticleMapper extends MyMapper<CmsArticle> , IdListMapper<CmsArticle,Long> {
}