package com.mt.portalcms.web.admin;

import com.mt.portalcms.common.base.CommonResult;
import com.mt.portalcms.common.enums.ResponseCode;
import com.mt.portalcms.pojo.CmsColumn;
import com.mt.portalcms.service.ICmsColumnService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@Api(tags = "管理员栏目接口")
@RestController("cmsColumnAdmin")
@RequestMapping("/admin/cmsColumn")
public class CmsColumnController {
    @Autowired
    ICmsColumnService cmsColumnService;

    @ApiOperation(value = "分页查询栏目", notes = "传入类型id，父id及分页参数")
    @GetMapping("/list")
    public CommonResult selectColumn() {
        return CommonResult.success(cmsColumnService.selectAll());
    }

    @ApiOperation(value = "根据栏目id查询栏目", notes = "传入栏目id")
    @GetMapping("/findById")
    public CommonResult<CmsColumn> selectById(Long id) {
        return CommonResult.success(cmsColumnService.selectById(id));
    }


    @ApiOperation(value = "增加栏目")
    @PostMapping("/insertColumn")
    public CommonResult<Integer> insertColunm(@RequestBody CmsColumn cmsColumn) {
        if (StringUtils.isEmpty(cmsColumn.getColumnName())) {
            return CommonResult.fail(-1, "导航名字不能为空");
        }
        Integer integer = null;
        try {
            integer = cmsColumnService.insertColumn(cmsColumn);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.FAILED);
        }

        return CommonResult.success(integer);
    }

    @ApiOperation(value = "更新栏目")
    @PutMapping("/updateColumn")
    public CommonResult<Integer> updateColumn(@RequestBody CmsColumn cmsColumn) {
        return CommonResult.success(cmsColumnService.updateColumn(cmsColumn));
    }

    @ApiOperation(value = "删除栏目", notes = "传入栏目id")
    @DeleteMapping("/deleteColumn/{id}")
    public CommonResult<Integer> deleteCOlumn(@PathVariable("id") Long id) {
        int val = -1;
        try {
            val = cmsColumnService.deleteColumn(id);
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
