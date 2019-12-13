package com.mt.portalcms.web.admin;

import com.mt.portalcms.common.base.CommonResult;
import com.mt.portalcms.common.enums.ResponseCode;
import com.mt.portalcms.pojo.CmsAdvertisement;
import com.mt.portalcms.service.ICmsAdvertisementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "管理员广告信息接口")
@RestController(value = "cmsAdvertisement")
@RequestMapping("/admin/Advertisement")
public class AdvertisementController {
    @Autowired
    ICmsAdvertisementService cmsAdvertisementService;
    @ApiOperation(value = "查询所有广告信息", notes = "不需要传递参数")
    @GetMapping("/list")
    public CommonResult listAdvertisement() {
        return CommonResult.success(cmsAdvertisementService.listAdvertisement());
    }

    @ApiOperation(value = "删除广告", notes = "传广告id")
    @DeleteMapping("deleteAdvertisement")
    public CommonResult<Integer> deleteAdvertisement(@RequestParam("id") Long id) {
        int val = -1 ;
        try {
            val = cmsAdvertisementService.deleteAdvertisement(id);
            if (val == 1) {
                return CommonResult.success(val);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.FAILED);
        }
        return CommonResult.fail(-1, "删除失败,传递的id不存在");
    }

    @ApiOperation(value = "增加广告信息")
    @PostMapping("/insertAdvertisement")
    public CommonResult<Integer> insertAdvertisement(@RequestBody CmsAdvertisement cmsAdvertisement) {
        return CommonResult.success(cmsAdvertisementService.insertAdvertisement(cmsAdvertisement));
    }

    @ApiOperation(value = "修改广告信息")
    @PutMapping("/updateAdvertisement")
    public CommonResult<Integer> updateAdvertisement(@RequestBody CmsAdvertisement cmsAdvertisement) {
        return CommonResult.success(cmsAdvertisementService.updateAdvertisement(cmsAdvertisement));
    }

    //回显页面的数据显示
    @ApiOperation(value = "根据id查询广告信息", notes = "传入广告id信息")
    @GetMapping("/findById")
    public CommonResult<CmsAdvertisement> findAdvertisementById(Long id) {
        return CommonResult.success(cmsAdvertisementService.findAdvertisementById(id));
    }

}
