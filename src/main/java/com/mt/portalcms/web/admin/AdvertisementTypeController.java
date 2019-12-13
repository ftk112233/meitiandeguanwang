package com.mt.portalcms.web.admin;

import com.mt.portalcms.common.base.CommonResult;
import com.mt.portalcms.common.enums.ResponseCode;
import com.mt.portalcms.pojo.CmsAdvertisementType;
import com.mt.portalcms.service.ICmsAdvertisementTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "管理员广告位管理接口")
@RestController(value = "cmsAdvertisementType")
@RequestMapping("/admin/advertisementType")
public class AdvertisementTypeController {
    @Autowired
    ICmsAdvertisementTypeService cmsAdvertisementTypeService;

    @ApiOperation(value = "查询所有广告位")
    @GetMapping("/list")
    public CommonResult listAdvertisementType() {
        return CommonResult.success(cmsAdvertisementTypeService.listAdvertisementType());

    }

    @ApiOperation(value = "删除广告位", notes = "传广告位id")
    @DeleteMapping("deleteAdvertisementType")
    public CommonResult<Integer> deleteAdvertisementType(Long id) {

        int val = -1;
        try {
            val = cmsAdvertisementTypeService.deleteAdvertisementType(id);
            if (val == 1) {
                return CommonResult.success(val);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.FAILED);
        }
        return CommonResult.fail(-1, "删除失败");
    }

    @ApiOperation(value = "增加广告位")
    @PostMapping("/insertAdvertisementType")
    public CommonResult<Integer> insertAdvertisementType(CmsAdvertisementType cmsAdvertisementType) {
        return CommonResult.success(cmsAdvertisementTypeService.insertAdvertisementType(cmsAdvertisementType));
    }

    @ApiOperation(value = "修改广告位信息")
    @PutMapping("/updateAdvertisementType")
    public CommonResult<Integer> updateAdvertisementType(CmsAdvertisementType cmsAdvertisementType) {
        return CommonResult.success(cmsAdvertisementTypeService.updateAdvertisementType(cmsAdvertisementType));
    }

    @ApiOperation(value = "根据id查询广告位")
    @GetMapping("/findById")
    public CommonResult<CmsAdvertisementType> findCmsAdvertisementTypeById(Long id) {
        return CommonResult.success(cmsAdvertisementTypeService.findcmsAdvertisementTypeById(id));
    }
}
