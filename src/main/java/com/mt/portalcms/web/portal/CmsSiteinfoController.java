package com.mt.portalcms.web.portal;

import com.mt.portalcms.common.base.CommonResult;
import com.mt.portalcms.pojo.CmsSiteinfo;
import com.mt.portalcms.service.ICmsSiteinfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "门户网站信息")
@RestController
@RequestMapping("/siteInfo")
public class CmsSiteinfoController {
    @Autowired
    ICmsSiteinfoService cmsSiteinfoService;

    @ApiOperation(value = "查询网站全部基础信息")
    @GetMapping("/findAll")
    public CommonResult<List<CmsSiteinfo>> findAll() {
        return CommonResult.success(cmsSiteinfoService.findAll());
    }
}
