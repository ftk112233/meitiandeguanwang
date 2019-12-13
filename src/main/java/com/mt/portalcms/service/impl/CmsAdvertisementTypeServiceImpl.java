package com.mt.portalcms.service.impl;

import com.github.pagehelper.PageHelper;
import com.mt.portalcms.common.base.CommonPage;
import com.mt.portalcms.mapper.CmsAdvertisementTypeMapper;
import com.mt.portalcms.pojo.CmsAdvertisementType;
import com.mt.portalcms.service.ICmsAdvertisementTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
public class CmsAdvertisementTypeServiceImpl implements ICmsAdvertisementTypeService {

    @Autowired
    CmsAdvertisementTypeMapper cmsAdvertisementTypeMapper;
    Integer page = 0;
    Integer pageSize = 1000;

    //管理员查询所有的广告位
    @Override
    public CommonPage<CmsAdvertisementType> listAdvertisementType() {
        Example example = new Example(CmsAdvertisementType.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("deleted", 0);
        PageHelper.startPage(page, pageSize);
        List<CmsAdvertisementType> cmsAdvertisementType = cmsAdvertisementTypeMapper.selectByExample(example);
        return CommonPage.restPage(cmsAdvertisementType);
    }

    //按照id删除指定的广告位
    @Override
    public Integer deleteAdvertisementType(Long id) {
        CmsAdvertisementType cmsAdvertisementType = new CmsAdvertisementType();
        cmsAdvertisementType.setId(id);
        cmsAdvertisementType.setDeleted(1);
        return cmsAdvertisementTypeMapper.updateByPrimaryKeySelective(cmsAdvertisementType);
    }

    //插入新的广告位
    @Override
    public Integer insertAdvertisementType(CmsAdvertisementType cmsAdvertisementType) {
        Date date = new Date();
        cmsAdvertisementType.setCreateTime(date);
        cmsAdvertisementType.setUpdateTime(date);
        cmsAdvertisementType.setStatus(0);
        cmsAdvertisementType.setDeleted(0);
        return cmsAdvertisementTypeMapper.insert(cmsAdvertisementType);
    }

    //更新广告位信息
    @Override
    public Integer updateAdvertisementType(CmsAdvertisementType cmsAdvertisementType) {
        cmsAdvertisementType.setUpdateTime(new Date());
        Example example = new Example(CmsAdvertisementType.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", cmsAdvertisementType.getId());
        return cmsAdvertisementTypeMapper.updateByExampleSelective(cmsAdvertisementType, example);
    }

    @Override
    public CmsAdvertisementType findcmsAdvertisementTypeById(Long id) {
        return cmsAdvertisementTypeMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<CmsAdvertisementType> listAdvertisementForUser() {
        Example example = new Example(CmsAdvertisementType.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("deleted", 0).andEqualTo("status", 0);
        return cmsAdvertisementTypeMapper.selectByExample(example);
    }
}
