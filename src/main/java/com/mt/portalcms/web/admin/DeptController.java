package com.mt.portalcms.web.admin;

import com.mt.portalcms.common.base.CommonResult;
import com.mt.portalcms.common.enums.ResponseCode;
import com.mt.portalcms.pojo.Dept;
import com.mt.portalcms.service.IDeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "管理员部门信息接口")
@RestController(value = "deptAdmin")
@RequestMapping("/admin/Dept")
public class DeptController {
    @Autowired
    IDeptService deptService;

    @ApiOperation(value = "查询所有的部门信息")
    @GetMapping("/list")
    public CommonResult listDept() {
        return CommonResult.success(deptService.findAll());
    }

    @ApiOperation(value = "新增部门信息")
    @PostMapping("/insert")
    public CommonResult<Integer> insertDept(@RequestBody Dept dept) {

        return CommonResult.success(deptService.insertDept(dept));
    }

    @ApiOperation(value = "修改部门信息")
    @PostMapping("/update")
    public CommonResult<Integer> updateDept(@RequestBody Dept dept) {
        return CommonResult.success(deptService.updateDept(dept));
    }

    @ApiOperation(value = "删除部门信息")
    @PostMapping("/delete")
    public CommonResult<Integer> deletedDept(Long id) {
        int val = -1;
        try {
            val = deptService.deletedDept(id);
            if (val == 1) {
                return CommonResult.success(val);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.FAILED);
        }
        return CommonResult.fail(-1, "删除失败");
    }
}
