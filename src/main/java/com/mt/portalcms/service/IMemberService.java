package com.mt.portalcms.service;

import com.mt.portalcms.common.base.CommonResult;
import com.mt.portalcms.pojo.Dept;
import com.mt.portalcms.pojo.Member;

import java.util.List;

public interface IMemberService {
    List<Member> findAll(Long deptId);

    List<Member> findAllFroUser();

    Integer updateMemberById(Member member);

    Integer deletedMember(Long id);

    Integer insertMember(Member member);

    Member findMemberById(Long id);

    List<Member> findByDeptId(Long deptId);

    List<Dept> findAllDept();

    List<Member> findIndexList();

    Integer updateIndexStatus(Integer id, Integer indexStatus);

    Integer updateSort(Integer id, Integer sort);

    Integer updateIndexSort(Integer id, Integer indexSort);
}
