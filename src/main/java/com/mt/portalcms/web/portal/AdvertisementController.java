package com.mt.portalcms.web.portal;

import com.mt.portalcms.common.base.CommonResult;
import com.mt.portalcms.service.ICmsAdvertisementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "门户轮播图信息接口")
@RestController
@RequestMapping("/advertisement")
public class AdvertisementController {
    @Autowired
    ICmsAdvertisementService cmsAdvertisementService;

    @ApiOperation(value = "查询用户可见轮播图信息", notes = "广告位id不能为空")
    @GetMapping("/listForUser")
    public CommonResult listAdvertisement(Long type_id, Integer page, Integer pageSize) {
        return CommonResult.success(cmsAdvertisementService.listAdvertisementForUser(type_id));
    }
}
