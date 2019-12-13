package com.mt.portalcms.service;

import com.mt.portalcms.common.base.CommonPage;
import com.mt.portalcms.pojo.CmsArticle;
import com.mt.portalcms.pojo.CmsTopic;

public interface ICmsTopicService {
    //管理员查询
    CommonPage<CmsTopic> listTopic(Integer page, Integer pageSize);

    //门户查询
    CommonPage<CmsTopic> selectTopic(Long columnId, Integer page, Integer pageSize);

    CmsTopic selectById(Long id);

    Integer insertTopic(CmsTopic cmsTopic);

    Integer updateTopic(CmsTopic cmsTopic);

    Integer deleteTopic(Long id);
}
