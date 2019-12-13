package com.mt.portalcms.service;

import com.mt.portalcms.pojo.Dept;

import java.util.List;

public interface IDeptService {

    List<Dept> findAllFroUser();

    List<Dept> findAll();

    Integer insertDept(Dept dept);

    Integer updateDept(Dept dept);

    Integer deletedDept(Long id);
}
