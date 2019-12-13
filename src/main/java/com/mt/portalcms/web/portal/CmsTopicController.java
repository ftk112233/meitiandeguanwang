package com.mt.portalcms.web.portal;

import com.mt.portalcms.common.base.CommonResult;
import com.mt.portalcms.common.enums.ResponseCode;
import com.mt.portalcms.pojo.CmsTopic;
import com.mt.portalcms.service.ICmsTopicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "门户专题接口")
@RestController
@RequestMapping("/topic")
public class CmsTopicController {
    @Autowired
    ICmsTopicService cmsTopicService;

    @ApiOperation(value = "分页查询专题", notes = "传入栏目id及分页参数")
    @GetMapping("/list")
    public CommonResult listTopic(Long columnId, Integer page, Integer pageSize) {
        return CommonResult.success(cmsTopicService.selectTopic(columnId, page, pageSize));
    }


}
