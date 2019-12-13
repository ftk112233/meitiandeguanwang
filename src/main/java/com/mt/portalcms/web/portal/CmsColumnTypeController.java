package com.mt.portalcms.web.portal;


import com.mt.portalcms.common.base.CommonResult;
import com.mt.portalcms.pojo.CmsColumnType;
import com.mt.portalcms.service.ICmsColumnTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "门户栏目分类接口")
@RestController
@RequestMapping("/columnType")
public class CmsColumnTypeController {

    @Autowired
    ICmsColumnTypeService cmsColumnTypeService;

    @ApiOperation(value = "查询所有栏目分类")
    @GetMapping("/list")
    public CommonResult<List<CmsColumnType>> listColumnType() {
        List<CmsColumnType> cmsColumnTypes = cmsColumnTypeService.selectColumnType();
        return CommonResult.success(cmsColumnTypes);
    }


}