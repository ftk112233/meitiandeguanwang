package com.mt.portalcms.service;

import com.mt.portalcms.common.base.CommonPage;
import com.mt.portalcms.pojo.CmsColumn;

import java.util.List;

public interface ICmsColumnService {
    List<CmsColumn> findByParentId(Long typeId);

    CmsColumn selectById(Long id);

    Integer insertColumn(CmsColumn cmsColumn);

    Integer updateColumn(CmsColumn cmsColumn);

    Integer deleteColumn(Long id);

    List<CmsColumn> selectAll();
}