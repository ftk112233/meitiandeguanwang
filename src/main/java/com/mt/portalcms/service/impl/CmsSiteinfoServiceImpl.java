package com.mt.portalcms.service.impl;

import com.mt.portalcms.mapper.CmsSiteinfoMapper;
import com.mt.portalcms.pojo.CmsSiteinfo;
import com.mt.portalcms.service.ICmsSiteinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
public class CmsSiteinfoServiceImpl implements ICmsSiteinfoService {
    @Autowired
    CmsSiteinfoMapper cmsSiteinfoMapper;

    @Override
    public List<CmsSiteinfo> findAll() {
        return cmsSiteinfoMapper.selectAll();
    }

    @Override
    public CmsSiteinfo findById(Long id) {
        return cmsSiteinfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer updateSiteInfo(CmsSiteinfo cmsSiteinfo) {
        cmsSiteinfo.setUpdateTime(new Date());
        Example example = new Example(CmsSiteinfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", cmsSiteinfo.getId());
        return cmsSiteinfoMapper.updateByExampleSelective(cmsSiteinfo, example);
    }
}
