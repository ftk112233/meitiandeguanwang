package com.mt.portalcms.service;

import com.mt.portalcms.common.base.CommonPage;
import com.mt.portalcms.pojo.CmsAdvertisementType;

import java.util.List;

public interface ICmsAdvertisementTypeService {
    CommonPage<CmsAdvertisementType> listAdvertisementType();//管理员查询

    Integer deleteAdvertisementType(Long id);

    Integer insertAdvertisementType(CmsAdvertisementType cmsAdvertisementType);

    Integer updateAdvertisementType(CmsAdvertisementType cmsAdvertisementType);

    CmsAdvertisementType findcmsAdvertisementTypeById(Long id);

    List<CmsAdvertisementType> listAdvertisementForUser();//用户查询
}
