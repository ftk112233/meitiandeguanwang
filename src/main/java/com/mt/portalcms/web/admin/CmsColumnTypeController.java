package com.mt.portalcms.web.admin;


import com.mt.portalcms.common.base.CommonResult;
import com.mt.portalcms.common.enums.ResponseCode;
import com.mt.portalcms.pojo.CmsColumnType;
import com.mt.portalcms.service.ICmsColumnTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "管理员栏目分类接口")
@RestController(value = "columnTypeAdmin")
@RequestMapping("/admin/columnType")
public class CmsColumnTypeController {

    @Autowired
    ICmsColumnTypeService cmsColumnTypeService;

    @ApiOperation(value = "查询所有栏目分类")
    @GetMapping("/list")
    public CommonResult<List<CmsColumnType>> listColumnType() {
        List<CmsColumnType> cmsColumnTypes = cmsColumnTypeService.listColumnType();
        return CommonResult.success(cmsColumnTypes);
    }

    @ApiOperation(value = "根据栏目分类id查询栏目分类", notes = "传入栏目类型id")
    @GetMapping("selectById")
    public CommonResult<CmsColumnType> selectById(Long id) {
        return CommonResult.success(cmsColumnTypeService.selectById(id));
    }

    @ApiOperation(value = "删除栏目类型", notes = "传栏目类型id")
    @DeleteMapping("deleteColumnType")
    public CommonResult<Integer> deleteColumnType(Long id) {

        int val = -1;
        try {
            val = cmsColumnTypeService.deleteColumnType(id);
            if (val == 1) {
                return CommonResult.success(val);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.FAILED);
        }
        return CommonResult.fail(-1, "删除失败");
    }


    @ApiOperation(value = "增加栏目类型")
    @PostMapping("/insertColumnType")
    public CommonResult<Integer> insertColumnType(CmsColumnType cmsColumnType) {

        return CommonResult.success(cmsColumnTypeService.insertColumnType(cmsColumnType));
    }

    @ApiOperation(value = "修改栏目类型")
    @PutMapping("/updateColumnType")
    public CommonResult<Integer> updateColumnType(CmsColumnType cmsColumnType) {

        return CommonResult.success(cmsColumnTypeService.updateColumnType(cmsColumnType));
    }


}