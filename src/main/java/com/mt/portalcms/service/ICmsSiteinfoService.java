package com.mt.portalcms.service;

import com.mt.portalcms.pojo.CmsSiteinfo;

import java.util.List;

public interface ICmsSiteinfoService {

    List<CmsSiteinfo> findAll();

    CmsSiteinfo findById(Long id);

    Integer updateSiteInfo(CmsSiteinfo cmsSiteinfo);
}
