package com.mt.portalcms.service.impl;

import com.github.pagehelper.PageHelper;
import com.mt.portalcms.common.base.CommonResult;
import com.mt.portalcms.mapper.DeptMapper;
import com.mt.portalcms.mapper.MemberMapper;
import com.mt.portalcms.pojo.Dept;
import com.mt.portalcms.pojo.Member;
import com.mt.portalcms.service.IMemberService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
public class MemberServiceImpl implements IMemberService {
    @Autowired
    MemberMapper memberMapper;

    @Autowired
    DeptMapper deptMapper;

    //管理员查询所有
    @Override
    public List<Member> findAll(Long deptId) {
        if (deptId == null) {
            Example example = new Example(Member.class);
            example.orderBy("sort").desc();
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("deleted", 0);
            return memberMapper.selectByExample(example);
        } else {
            Example example = new Example(Member.class);
            example.orderBy("sort").desc();
            example.createCriteria()
                    .andEqualTo("deptId", deptId)
                    .andEqualTo("deleted", 0);
            return memberMapper.selectByExample(example);
        }
    }

    //用户查询所有
    @Override
    public List<Member> findAllFroUser() {
        Example example = new Example(Member.class);
        example.orderBy("sort").desc();
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("deleted", 0).andEqualTo("status", 0);
        return memberMapper.selectByExample(example);
    }

    //管理员更新成员信息
    @Override
    public Integer updateMemberById(Member member) {
        member.setUpdatetime(new Date());
        Example example = new Example(Member.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", member.getId());
        return memberMapper.updateByExampleSelective(member, example);
    }

    //伪删除成员信息
    @Override
    public Integer deletedMember(Long id) {
        Member member = new Member();
        member.setUpdatetime(new Date());
        member.setId(id);
        member.setDeleted(1);
        return memberMapper.updateByPrimaryKeySelective(member);
    }

    //添加成员
    @Override
    public Integer insertMember(Member member) {
        member.setCreatetime(new Date());
        member.setUpdatetime(new Date());
        member.setDeleted(0);
        return memberMapper.insert(member);
    }

    //根据id查询
    @Override
    public Member findMemberById(Long id) {
        return memberMapper.selectByPrimaryKey(id);
    }

    //根据部门id查询成员普通用户
    @Override
    public List<Member> findByDeptId(Long deptId) {
        Example example = new Example(Member.class);
        example.orderBy("sort").desc();
        example.createCriteria()
                .andEqualTo("deptId", deptId)
                .andEqualTo("deleted", 0)
                .andEqualTo("status", 0);
        return memberMapper.selectByExample(example);
    }

    @Override
    public List<Dept> findAllDept() {
        return deptMapper.selectAll();
    }

    @Override
    public List<Member> findIndexList() {
        int page = 0;
        int pageSize = 5;
        Example example = new Example(Member.class);
        example.orderBy("indexSort").desc();
        example.createCriteria()
                .andEqualTo("deleted", 0)
                .andEqualTo("indexStatus", 0);
        PageHelper.startPage(page, pageSize);
        return memberMapper.selectByExample(example);
    }

    @Override
    public Integer updateIndexStatus(Integer id, Integer indexStatus) {
        List<Member> members = memberMapper.selectAll();
        Member member = memberMapper.selectByPrimaryKey(id);
        member.setUpdatetime(new Date());
        member.setIndexStatus(indexStatus);
        Example example = new Example(Member.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", id);
        return memberMapper.updateByExampleSelective(member,example);
    }

    @Override
    public Integer updateIndexSort(Integer id, Integer indexSort) {
        Member member = memberMapper.selectByPrimaryKey(id);
        member.setUpdatetime(new Date());
        member.setIndexSort(indexSort);
        Example example = new Example(Member.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", id);
        return memberMapper.updateByExampleSelective(member,example);
    }

    @Override
    public Integer updateSort(Integer id, Integer sort) {
        Member member = memberMapper.selectByPrimaryKey(id);
        member.setUpdatetime(new Date());
        member.setSort(sort);
        Example example = new Example(Member.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", member.getId());
        return memberMapper.updateByExampleSelective(member, example);
    }




}
