package com.mt.portalcms.service.impl;

import com.github.pagehelper.PageHelper;
import com.mt.portalcms.common.base.CommonPage;
import com.mt.portalcms.mapper.CmsColumnMapper;
import com.mt.portalcms.pojo.CmsColumn;

import com.mt.portalcms.service.ICmsColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
public class CmsColumnServiceImpl implements ICmsColumnService {
    @Autowired
    CmsColumnMapper cmsColumnMapper;

    //通过父id查询栏目
    @Override
    public List<CmsColumn> findByParentId(Long typeId) {

        Example example = new Example(CmsColumn.class);
        example.createCriteria().andEqualTo("typeId", typeId)
                .andEqualTo("deleted", 0)
                .andEqualTo("status", 0);
        List<CmsColumn> cmsColumns = cmsColumnMapper.selectByExample(example);
        return cmsColumns;
    }

    @Override
    public CmsColumn selectById(Long id) {
        return cmsColumnMapper.selectByPrimaryKey(id);
    }


    @Override
    public Integer insertColumn(CmsColumn cmsColumn) {
        cmsColumn.setStatus(0);
        cmsColumn.setDeleted(0);
        Date date = new Date();
        cmsColumn.setCreateTime(date);
        cmsColumn.setUpdateTime(date);
        return cmsColumnMapper.insert(cmsColumn);
    }

    @Override
    public Integer updateColumn(CmsColumn cmsColumn) {
        Example example = new Example(CmsColumn.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", cmsColumn.getId());
        cmsColumn.setUpdateTime(new Date());
        return cmsColumnMapper.updateByExampleSelective(cmsColumn, example);

    }

    //删除栏目
    @Override
    public Integer deleteColumn(Long id) {
        CmsColumn cmsColumn = new CmsColumn();
        cmsColumn.setId(id);
        cmsColumn = cmsColumnMapper.selectOne(cmsColumn);
        cmsColumn.setDeleted(1);
        Example example = new Example(CmsColumn.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", cmsColumn.getId());
        return cmsColumnMapper.updateByExampleSelective(cmsColumn, example);
    }

    @Override
    public List<CmsColumn> selectAll() {
        Example example = new Example(CmsColumn.class);
        example.createCriteria().andEqualTo("deleted", 0);

        List<CmsColumn> cmsColumns = cmsColumnMapper.selectByExample(example);

        return cmsColumns;
    }
}
