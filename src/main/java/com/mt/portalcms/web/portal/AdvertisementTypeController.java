package com.mt.portalcms.web.portal;

import com.mt.portalcms.common.base.CommonResult;
import com.mt.portalcms.service.ICmsAdvertisementTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "门户广告位接口")
@RestController
@RequestMapping("/advertisemnetType")
public class AdvertisementTypeController {
    @Autowired
    ICmsAdvertisementTypeService cmsAdvertisementTypeService;

    @ApiOperation(value = "用户查看广告位")
    @GetMapping("/selectByUser")
    public CommonResult listAdvertisement() {
        return CommonResult.success(cmsAdvertisementTypeService.listAdvertisementForUser());
    }
}
