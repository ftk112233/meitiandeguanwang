package com.mt.portalcms.web.portal;

import com.mt.portalcms.common.base.CommonResult;
import com.mt.portalcms.service.IMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "门户公司成员信息接口")
@RestController
@RequestMapping("/member")
public class MemberController {
    @Autowired
    IMemberService memberService;

    @ApiOperation(value = "查询用户可见所有的成员信息")
    @GetMapping("/listForUser")
    public CommonResult listMember() {
        return CommonResult.success(memberService.findAllFroUser());
    }

    @ApiOperation(value = "根据部门号查询用户可见所有的成员信息")
    @GetMapping("/listByDept")
    public CommonResult listForDeptId(Long deptId) {
        return CommonResult.success(memberService.findByDeptId(deptId));
    }

    @ApiOperation(value = "查询首页可见的所有的成员信息")
    @GetMapping("/indexList")
    public CommonResult indexList() {
        return CommonResult.success(memberService.findIndexList());
    }
}
