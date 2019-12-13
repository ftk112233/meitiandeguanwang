package com.mt.portalcms.web.admin;

import com.mt.portalcms.common.base.CommonResult;
import com.mt.portalcms.pojo.CmsSiteinfo;
import com.mt.portalcms.service.ICmsSiteinfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "管理员网站基本信息")
@RestController(value = "cmsSiteinfo")
@RequestMapping("/admin/siteinfo")
public class CmsSiteinfoController {
    @Autowired
    ICmsSiteinfoService cmsSiteinfoService;

    @ApiOperation(value = "查询网站全部信息")
    @GetMapping("/findAll")
    public CommonResult<List<CmsSiteinfo>> findAll() {
        return CommonResult.success(cmsSiteinfoService.findAll());
    }

    @ApiOperation(value = "根据id查询")
    @GetMapping("/findById")
    public CommonResult<CmsSiteinfo> findById(Long id) {
        return CommonResult.success(cmsSiteinfoService.findById(id));
    }

    @ApiOperation(value = "修改网站信息")
    @PutMapping("/updateSiteInfo")
    public CommonResult<Integer> updateSiteInfo(@RequestBody CmsSiteinfo cmsSiteinfo) {

        return CommonResult.success(cmsSiteinfoService.updateSiteInfo(cmsSiteinfo));
    }
}
