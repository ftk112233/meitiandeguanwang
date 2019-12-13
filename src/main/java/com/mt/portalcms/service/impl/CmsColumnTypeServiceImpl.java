package com.mt.portalcms.service.impl;

import com.mt.portalcms.mapper.CmsColumnTypeMapper;
import com.mt.portalcms.pojo.CmsColumn;
import com.mt.portalcms.pojo.CmsColumnType;
import com.mt.portalcms.service.ICmsColumnTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.annotation.ColumnType;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/*
 * 栏目类型实现类
 * */
@Service
public class CmsColumnTypeServiceImpl implements ICmsColumnTypeService {
    @Autowired
    CmsColumnTypeMapper cmsColumnTypeMapper;


    //查询所有栏目
    @Override
    public List<CmsColumnType> listColumnType() {
        return cmsColumnTypeMapper.selectAll();
    }

    //查询未删所有栏目
    @Override
    public List<CmsColumnType> selectColumnType() {
        Example example = new Example(CmsColumnType.class);
        Example.Criteria criteria = example.createCriteria().andEqualTo("deleted", 0).andEqualTo("status", 0);
        return cmsColumnTypeMapper.selectByExample(example);
    }

    @Override
    public CmsColumnType selectById(Long id) {
        return cmsColumnTypeMapper.selectByPrimaryKey(id);
    }

    //逻辑删除栏目类型
    @Override
    public Integer deleteColumnType(Long id) {
        CmsColumnType cmsColumnType = new CmsColumnType();
        cmsColumnType.setId(id);
        cmsColumnType = cmsColumnTypeMapper.selectOne(cmsColumnType);
        cmsColumnType.setDeleted(1);
        Example example = new Example(CmsColumnType.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", cmsColumnType.getId());
        return cmsColumnTypeMapper.updateByExampleSelective(cmsColumnType, example);
    }

    //增加栏目类型
    @Override
    public Integer insertColumnType(CmsColumnType cmsColumnType) {
        return cmsColumnTypeMapper.insert(cmsColumnType);
    }


    //修改栏目类型
    @Override
    public Integer updateColumnType(CmsColumnType cmsColumnType) {
        Example example = new Example(CmsColumnType.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", cmsColumnType.getId());
        return cmsColumnTypeMapper.updateByExampleSelective(cmsColumnType, example);
    }
}
