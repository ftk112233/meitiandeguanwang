package com.mt.portalcms.service.impl;

import com.github.pagehelper.PageHelper;
import com.mt.portalcms.common.base.CommonPage;
import com.mt.portalcms.mapper.CmsTopicMapper;
import com.mt.portalcms.pojo.CmsColumnType;
import com.mt.portalcms.pojo.CmsTopic;
import com.mt.portalcms.service.ICmsTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class CmsTopicServiceImpl implements ICmsTopicService {
    @Autowired
    CmsTopicMapper cmsTopicMapper;

    //管理员查询
    @Override
    public CommonPage<CmsTopic> listTopic(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<CmsTopic> cmsTopics = cmsTopicMapper.selectAll();
        CommonPage<CmsTopic> cmsTopicCommonPage = CommonPage.restPage(cmsTopics);

        return cmsTopicCommonPage;
    }

    //门户查询
    @Override
    public CommonPage<CmsTopic> selectTopic(Long columnId, Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        Example example = new Example(CmsTopic.class);
        example.createCriteria().andEqualTo("columnId", columnId).andEqualTo("deleted", 0).andEqualTo("status", 0);
        List<CmsTopic> cmsTopics = cmsTopicMapper.selectByExample(example);
        CommonPage<CmsTopic> cmsTopicCommonPage = CommonPage.restPage(cmsTopics);

        return cmsTopicCommonPage;
    }

    @Override
    public CmsTopic selectById(Long id) {
        return cmsTopicMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer insertTopic(CmsTopic cmsTopic) {
        return cmsTopicMapper.insert(cmsTopic);
    }

    @Override
    public Integer updateTopic(CmsTopic cmsTopic) {
        Example example = new Example(CmsTopic.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", cmsTopic.getId());
        return cmsTopicMapper.updateByExampleSelective(cmsTopic, example);
    }

    @Override
    public Integer deleteTopic(Long id) {
        CmsTopic cmsTopic = new CmsTopic();
        cmsTopic.setId(id);
        cmsTopic = cmsTopicMapper.selectOne(cmsTopic);
        cmsTopic.setDeleted(1);
        Example example = new Example(CmsTopic.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", cmsTopic.getId());
        return cmsTopicMapper.updateByExampleSelective(cmsTopic, example);
    }
}
