package com.mt.portalcms.service.impl;

import com.mt.portalcms.mapper.ItemsMapper;
import com.mt.portalcms.pojo.Items;
import com.mt.portalcms.service.ItemsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
public class ItemsServiceImpl implements ItemsService {
    @Autowired
    ItemsMapper itemsMapper;

    /**
     * 后台查询所有项目
     *
     * @return
     */
    @Override
    public List<Items> list() {
        Example example = new Example(Items.class);
        example.createCriteria().andEqualTo("deleted", 0);
        example.orderBy("sort").desc();
        return itemsMapper.selectByExample(example);
    }

    /**
     * 插入项目
     *
     * @param items
     * @return
     */
    @Override
    public Integer insert(Items items) {
        Date date = new Date();
        items.setCreateTime(date);
        items.setUpdateTime(date);
        items.setStatus(1);
        items.setDeleted(0);
        items.setSort(0);
        return itemsMapper.insertSelective(items);
    }

    /**
     * 更新项目
     *
     * @param items
     * @return
     */
    @Override
    public Integer update(Items items) {
        items.setUpdateTime(new Date());
        return itemsMapper.updateByPrimaryKeySelective(items);
    }

    /**
     * 删除项目
     *
     * @param id
     * @return
     */
    @Override
    public Integer delete(Long id) {
        Items items = new Items();
        items.setId(id);
        items.setDeleted(1);
        return itemsMapper.updateByPrimaryKeySelective(items);
    }

    /**
     * 根据id查询项目
     *
     * @param id
     * @return
     */
    @Override
    public Items findById(Long id) {
        return itemsMapper.selectByPrimaryKey(id);
    }

    /**
     * 前台查询项目信息
     *
     * @return
     */

    @Override
    public List<Items> select() {
        Example example = new Example(Items.class);
        example.createCriteria().andEqualTo("deleted", 0).andEqualTo("status", 0);
        example.orderBy("sort").desc();
        return itemsMapper.selectByExample(example);
    }
}
