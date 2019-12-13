package com.mt.portalcms.web.portal;

import com.mt.portalcms.common.base.CommonResult;
import com.mt.portalcms.service.IDeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "门户部门信息接口")
@RestController
@RequestMapping("/Dept")
public class DeptController {
    @Autowired
    IDeptService deptService;

    @ApiOperation(value = "查询用户可见所有的部门信息")
    @GetMapping("/listForUser")
    public CommonResult listMember() {
        return CommonResult.success(deptService.findAllFroUser());
    }

}
