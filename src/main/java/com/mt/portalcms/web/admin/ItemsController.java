package com.mt.portalcms.web.admin;

import com.mt.portalcms.common.base.CommonResult;
import com.mt.portalcms.common.enums.ResponseCode;
import com.mt.portalcms.pojo.Items;
import com.mt.portalcms.service.ItemsService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("adminItems")
@RequestMapping("/admin/items")
@Api(tags = "管理员项目信息接口")
public class ItemsController {
    @Autowired
    ItemsService itemsService;

    @GetMapping("/list")
    public CommonResult<List<Items>> list() {
        return CommonResult.success(itemsService.list());
    }

    @GetMapping("/findById")
    public CommonResult<Items> findById(Long id) {
        return CommonResult.success(itemsService.findById(id));
    }

    @PutMapping("/update")
    public CommonResult update(@RequestBody Items items) {

        if (itemsService.update(items) == 1) {
            return CommonResult.success();
        }
        return CommonResult.fail(ResponseCode.FAILED);
    }

    @PostMapping("/insert")
    public CommonResult insert(@RequestBody Items items) {
        if (itemsService.insert(items) == 1) {
            return CommonResult.success();
        }
        return CommonResult.fail(ResponseCode.FAILED);
    }

    @DeleteMapping("/delete")
    public CommonResult delete(@RequestParam("id") Long id) {
        if (itemsService.delete(id) == 1) {
            return CommonResult.success();
        }
        return CommonResult.fail(ResponseCode.FAILED);
    }
}
