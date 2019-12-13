package com.mt.portalcms.service;

import com.mt.portalcms.pojo.CmsColumnType;
/**
 * 栏目类型接口
 */

import java.util.List;

public interface ICmsColumnTypeService {

    List<CmsColumnType> listColumnType();

    List<CmsColumnType> selectColumnType();

    CmsColumnType selectById(Long id);

    Integer deleteColumnType(Long id);

    Integer insertColumnType(CmsColumnType cmsColumnType);

    Integer updateColumnType(CmsColumnType cmsColumnType);
}
