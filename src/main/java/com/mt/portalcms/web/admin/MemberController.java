package com.mt.portalcms.web.admin;

import com.mt.portalcms.common.base.CommonResult;
import com.mt.portalcms.common.enums.ResponseCode;
import com.mt.portalcms.pojo.Dept;
import com.mt.portalcms.pojo.Member;
import com.mt.portalcms.pojo.vo.IndexTest;
import com.mt.portalcms.service.IMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "管理员成员操作接口")
@RestController(value = "memberAdmin")
@RequestMapping("/admin/member")
public class MemberController {
    @Autowired
    IMemberService memberService;

    @ApiOperation(value = "查询所有的成员信息")
    @GetMapping("/list")
    public CommonResult listMember(Long deptId) {
        return CommonResult.success(memberService.findAll(deptId));
    }

    @ApiOperation(value = "修改成员信息")
    @PutMapping("/update")
    public CommonResult updateMember(@RequestBody Member member) {
        return CommonResult.success(memberService.updateMemberById(member));
    }

    @ApiOperation(value = "伪删除成员信息", notes = "传入id")
    @DeleteMapping("/deletedMember")
    public CommonResult<Integer> deletedMember(Long id) {
        int val = -1;
        try {
            val = memberService.deletedMember(id);
            if (val == 1) {
                return CommonResult.success(val);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.FAILED);
        }
        return CommonResult.fail(-1, "删除失败");
    }

    @ApiOperation(value = "添加成员信息")
    @PostMapping("/insertMember")
    public CommonResult<Integer> insertMember(@RequestBody Member member) {

        return CommonResult.success(memberService.insertMember(member));
    }

    @ApiOperation(value = "根据id查询成员信息", notes = "传入id")
    @GetMapping("/selectById")
    public CommonResult<Member> findMemberById(Long id) {
        return CommonResult.success(memberService.findMemberById(id));
    }

    @ApiOperation(value = "查询所有部门信息")
    @GetMapping("/selectDept")
    public CommonResult findAll() {
        return CommonResult.success(memberService.findAllDept());
    }

    @ApiOperation(value = "更改首页权重信息")
    @PutMapping("/updateIndexSort")
    public CommonResult updateIndexSort(@RequestBody IndexTest indexTest) {
        return CommonResult.success(memberService.updateIndexSort(indexTest.getId(), indexTest.getIndexSort()));
    }

    @ApiOperation(value = "更改部门页权重信息")
    @PutMapping("/updateSort")
    public CommonResult updateSort(@RequestBody IndexTest indexTest) {
        return CommonResult.success(memberService.updateSort(indexTest.getId(), indexTest.getSort()));
    }

    @ApiOperation(value = "更改首页展示状态信息")
    @PutMapping("/updateIndexStatus")
    public CommonResult updateIndexStatus(@RequestBody IndexTest indexTest) {
        return CommonResult.success(memberService.updateIndexStatus(indexTest.getId(), indexTest.getIndexStatus()));
    }
}
