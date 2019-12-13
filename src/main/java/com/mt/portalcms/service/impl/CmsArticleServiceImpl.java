package com.mt.portalcms.service.impl;

import com.mt.portalcms.mapper.CmsArticleContentMapper;
import com.mt.portalcms.mapper.CmsArticleMapper;
import com.mt.portalcms.mapper.CmsColumnMapper;
import com.mt.portalcms.mapper.CmsTopicMapper;
import com.mt.portalcms.pojo.CmsArticle;
import com.mt.portalcms.pojo.CmsArticleContent;
import com.mt.portalcms.pojo.CmsColumn;
import com.mt.portalcms.pojo.CmsTopic;
import com.mt.portalcms.pojo.vo.CmsArticleVo;
import com.mt.portalcms.service.ICmsArticleService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

@Service
public class CmsArticleServiceImpl implements ICmsArticleService {
    @Autowired
    CmsArticleMapper cmsArticleMapper;

    @Autowired
    CmsArticleContentMapper cmsArticleContentMapper;

    @Autowired
    CmsTopicMapper cmsTopicMapper;

    /**
     * 后台查询相关专题文章
     *
     * @param topicId
     * @return
     */
    @Override
    public List<CmsArticle> listArticle(Long topicId) {
        Example example = new Example(CmsArticle.class);
        example.createCriteria().andEqualTo("topicId", topicId).andEqualTo("deleted", 0);
        example.orderBy("sort").desc();
        List<CmsArticle> cmsArticles = cmsArticleMapper.selectByExample(example);
        for (CmsArticle cmsArticle : cmsArticles) {
            CmsArticleContent cmsArticleContent = new CmsArticleContent();
            cmsArticleContent.setArticleId(cmsArticle.getId());
            List<CmsArticleContent> list = cmsArticleContentMapper.select(cmsArticleContent);
            if (list != null && list.size() != 0) {
                cmsArticle.setCmsArticleContents(list.get(0));
            }

        }
        return cmsArticles;
    }

    /**
     * 前台查询相关专题的文章
     *
     * @param topicId
     * @return
     */
    @Override
    public List<CmsArticle> selectArticle(Long topicId) {

        Example example = new Example(CmsArticle.class);
        example.createCriteria().andEqualTo("topicId", topicId).andEqualTo("deleted", 0).andEqualTo("status", 0);
        example.orderBy("sort").desc();
        List<CmsArticle> cmsArticles = cmsArticleMapper.selectByExample(example);
        for (CmsArticle cmsArticle : cmsArticles) {
            CmsArticleContent cmsArticleContent = new CmsArticleContent();
            cmsArticleContent.setArticleId(cmsArticle.getId());
            CmsArticleContent cmsArticleContent1 = cmsArticleContentMapper.select(cmsArticleContent).get(0);
            cmsArticle.setCmsArticleContents(cmsArticleContent1);
        }
        return cmsArticles;
    }

    @Override
    public CmsArticle selectById(Long id) {
        CmsArticle cmsArticle = cmsArticleMapper.selectByPrimaryKey(id);
        CmsArticleContent cmsArticleContent = new CmsArticleContent();
        cmsArticleContent.setArticleId(id);
        CmsArticleContent cmsArticleContent1 = cmsArticleContentMapper.select(cmsArticleContent).get(0);
        cmsArticle.setCmsArticleContents(cmsArticleContent1);
        return cmsArticle;
    }


    //增加文章内容
    @Override
    @Transactional
    public Integer insertArticle(CmsArticleVo cmsArticleVo) {

        //拷贝属性
        CmsArticle cmsArticle = new CmsArticle();
        try {
            BeanUtils.copyProperties(cmsArticle, cmsArticleVo);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        cmsArticle.setDeleted(0);
        cmsArticle.setStatus(1);
        cmsArticle.setSort(0);
        Date date = new Date();
        cmsArticle.setCreateTime(date);
        cmsArticle.setUpdateTime(date);

        cmsArticleMapper.insertSelective(cmsArticle);

        //将文章内容插入文章表
        CmsArticleContent cmsArticleContent = new CmsArticleContent();
        cmsArticleContent.setArticleId(cmsArticle.getId());
        cmsArticleContent.setContent(cmsArticleVo.getContent());

        return cmsArticleContentMapper.insert(cmsArticleContent);
    }

    //更新文章内容

    @Override
    @Transactional
    public Integer updateArticle(CmsArticleVo cmsArticleVo) {

        //修改更新时间
        CmsArticle cmsArticle = cmsArticleMapper.selectByPrimaryKey(cmsArticleVo.getArticleId());
        if (cmsArticleVo.getArticleTitle() != null) {
            cmsArticle.setArticleTitle(cmsArticleVo.getArticleTitle());
        }
        if (cmsArticleVo.getEnglishTitle() != null) {
            cmsArticle.setEnglishTitle(cmsArticleVo.getEnglishTitle());
        }
        cmsArticle.setUpdateTime(new Date());
        if (cmsArticleVo.getStatus() != null) {
            cmsArticle.setStatus(cmsArticleVo.getStatus());
        }
        if(cmsArticleVo.getPic()!=null){
            cmsArticle.setPic(cmsArticleVo.getPic());
        }
        if(cmsArticleVo.getArticleAbstract()!=null){
            cmsArticle.setArticleAbstract(cmsArticleVo.getArticleAbstract());
        }

        cmsArticleMapper.updateByPrimaryKey(cmsArticle);
        //更新文章内容表
        CmsArticleContent cmsArticleContent = new CmsArticleContent();
        cmsArticleContent.setArticleId(cmsArticleVo.getArticleId());
        CmsArticleContent cmsArticleContent1 = cmsArticleContentMapper.selectOne(cmsArticleContent);
        cmsArticleContent1.setContent(cmsArticleVo.getContent());
        Example example = new Example(CmsArticleContent.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("articleId", cmsArticleContent1.getArticleId());


        return cmsArticleContentMapper.updateByExample(cmsArticleContent1, example);
    }


    @Override
    public Integer deleteArticle(Long id) {
        CmsArticle cmsArticle = new CmsArticle();
        cmsArticle.setId(id);
        cmsArticle.setDeleted(1);
        return cmsArticleMapper.updateByPrimaryKeySelective(cmsArticle);
    }


    @Override
    public Integer findCount(CmsArticle cmsArticle) {
        return cmsArticleMapper.selectCount(cmsArticle);
    }
}
