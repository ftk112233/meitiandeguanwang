package com.mt.portalcms.web.portal;

import com.mt.portalcms.common.base.CommonResult;
import com.mt.portalcms.pojo.Items;
import com.mt.portalcms.service.ItemsService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/item")
@Api(tags = "门户项目信息接口")
public class ItemsController {
    @Autowired
    ItemsService itemsService;


    @GetMapping("/select")
    public CommonResult<List<Items>> select() {
        return CommonResult.success(itemsService.select());
    }

    @GetMapping("findById")
    public CommonResult<Items> findById(Long id) {
        return CommonResult.success(itemsService.findById(id));
    }
}
