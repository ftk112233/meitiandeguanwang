package com.mt.portalcms.service.impl;

import com.mt.portalcms.mapper.CmsArticleContentMapper;
import com.mt.portalcms.pojo.CmsArticle;
import com.mt.portalcms.pojo.CmsArticleContent;
import com.mt.portalcms.service.ICmsArticleContentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

@Service
public class CmsArticleContentServiceImpl implements ICmsArticleContentService {
    @Autowired
    CmsArticleContentMapper cmsArticleContentMapper;

    //根据文章id查询
    @Override
    public CmsArticleContent findByArticleId(Long articleId) {
        Example example = new Example(CmsArticleContent.class);
        example.createCriteria().andEqualTo("articleId", articleId);

        return cmsArticleContentMapper.selectByExample(example).get(0);
    }

    @Override
    public CmsArticleContent findByArticleContentId(Long id) {
        return cmsArticleContentMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer updateArticleContent(CmsArticleContent cmsArticleContent) {
        Example example = new Example(CmsArticleContent.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", cmsArticleContent.getId());
        return cmsArticleContentMapper.updateByExampleSelective(cmsArticleContent, example);
    }

    @Override
    public Integer insertArticleContent(CmsArticleContent cmsArticleContent) {
        return cmsArticleContentMapper.insert(cmsArticleContent);
    }

    @Override
    public Integer deleteArticleContent(Long id) {
        return cmsArticleContentMapper.deleteByPrimaryKey(id);
    }
}
