package com.mt.portalcms.web.portal;

import com.mt.portalcms.common.base.CommonResult;
import com.mt.portalcms.pojo.CmsColumn;
import com.mt.portalcms.service.ICmsColumnService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "门户栏目接口")
@RestController
@RequestMapping("/cmsColumn")
public class CmsColumnController {
    @Autowired
    ICmsColumnService cmsColumnService;

    @ApiOperation(value = "根据父id查询栏目", notes = "传入类型id，父id及分页参数")
    @GetMapping("/list/{id}")
    public CommonResult findByParentId(@PathVariable("id") Long typeId) {
        return CommonResult.success(cmsColumnService.findByParentId(typeId));
    }


}
