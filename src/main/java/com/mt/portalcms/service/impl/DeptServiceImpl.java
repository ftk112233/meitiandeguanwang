package com.mt.portalcms.service.impl;

import com.mt.portalcms.mapper.DeptMapper;
import com.mt.portalcms.pojo.Dept;
import com.mt.portalcms.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class DeptServiceImpl implements IDeptService {
    @Autowired
    DeptMapper deptMapper;

    @Override
    public List<Dept> findAllFroUser() {
        Example example = new Example(Dept.class);
        example.setOrderByClause("sort DESC");
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("deleted", 0).andEqualTo("status", 0);
        return deptMapper.selectByExample(example);
    }

    @Override
    public List<Dept> findAll() {
        Example example = new Example(Dept.class);
        example.setOrderByClause("sort DESC");
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("status", 0);
        return deptMapper.selectByExample(example);
    }

    @Override
    public Integer insertDept(Dept dept) {
        return deptMapper.insert(dept);
    }

    @Override
    public Integer updateDept(Dept dept) {
        Example example = new Example(Dept.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", dept.getId());
        return deptMapper.updateByExampleSelective(dept, example);
    }

    @Override
    public Integer deletedDept(Long id) {
        Dept dept = new Dept();
        Integer ids = Math.toIntExact(id);
        dept.setId(ids);
        dept.setStatus(1);
        return deptMapper.updateByPrimaryKeySelective(dept);
    }
}
