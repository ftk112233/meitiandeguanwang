package com.mt.portalcms.service;

import com.mt.portalcms.common.base.CommonPage;
import com.mt.portalcms.pojo.CmsAdvertisement;

public interface ICmsAdvertisementService {

    CommonPage<CmsAdvertisement> listAdvertisementForUser(Long type_id);

    CommonPage<CmsAdvertisement> listAdvertisement();

    Integer deleteAdvertisement(Long id);

    Integer insertAdvertisement(CmsAdvertisement cmsAdvertisement);

    Integer updateAdvertisement(CmsAdvertisement cmsAdvertisement);

    CmsAdvertisement findAdvertisementById(Long id);

}
