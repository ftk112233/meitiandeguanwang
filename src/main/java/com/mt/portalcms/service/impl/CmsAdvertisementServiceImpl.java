package com.mt.portalcms.service.impl;

import com.github.pagehelper.PageHelper;
import com.mt.portalcms.common.base.CommonPage;
import com.mt.portalcms.mapper.CmsAdvertisementMapper;
import com.mt.portalcms.pojo.CmsAdvertisement;
import com.mt.portalcms.service.ICmsAdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;

@Service
public class CmsAdvertisementServiceImpl implements ICmsAdvertisementService {
    @Autowired
    CmsAdvertisementMapper cmsAdvertisementMapper;
    Integer page = 0;
    Integer pageSize = 1000;

    //查询用户可见的广告位广告信息
    @Override
    public CommonPage<CmsAdvertisement> listAdvertisementForUser(Long type_id) {
        Example example = new Example(CmsAdvertisement.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("deleted", 0)
                .andEqualTo("status", 0);
               if (type_id!=null){
                   criteria.andEqualTo("type_id",type_id);
               }
        PageHelper.startPage(page, pageSize);
        return CommonPage.restPage(cmsAdvertisementMapper.selectByExample(example));
    }

    //查询所有的广告信息
    @Override
    public CommonPage<CmsAdvertisement> listAdvertisement() {
        Example example = new Example(CmsAdvertisement.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("deleted", 0);
        PageHelper.startPage(page, pageSize);
        return CommonPage.restPage(cmsAdvertisementMapper.selectByExample(example));
    }

    //删除广告（按照id删除）
    @Override
    public Integer deleteAdvertisement(Long id) {
        CmsAdvertisement cmsAdvertisement = new CmsAdvertisement();
        cmsAdvertisement.setUpdateTime(new Date());
        cmsAdvertisement.setId(id);
        cmsAdvertisement.setDeleted(1);
        return cmsAdvertisementMapper.updateByPrimaryKeySelective(cmsAdvertisement);
    }

    //插入新的广告数据
    @Override
    public Integer insertAdvertisement(CmsAdvertisement cmsAdvertisement) {
        cmsAdvertisement.setCreateTime(new Date());
        cmsAdvertisement.setUpdateTime(new Date());
        cmsAdvertisement.setStatus(0);
        cmsAdvertisement.setDeleted(0);
        return cmsAdvertisementMapper.insert(cmsAdvertisement);
    }

    //更新广告数据
    @Override
    public Integer updateAdvertisement(CmsAdvertisement cmsAdvertisement) {
        cmsAdvertisement.setUpdateTime(new Date());
        Example example = new Example(CmsAdvertisement.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", cmsAdvertisement.getId());
        return cmsAdvertisementMapper.updateByExampleSelective(cmsAdvertisement, example);
    }

    //根据id查询数据
    @Override
    public CmsAdvertisement findAdvertisementById(Long id) {
        CmsAdvertisement cmsAdvertisement = cmsAdvertisementMapper.selectByPrimaryKey(id);
        return cmsAdvertisement;
    }
}
