package com.mt.portalcms.web.admin;

import com.mt.portalcms.common.base.CommonResult;
import com.mt.portalcms.common.enums.ResponseCode;
import com.mt.portalcms.pojo.CmsTopic;
import com.mt.portalcms.service.ICmsTopicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "管理员专题接口")
@RestController("topicAdmin")
@RequestMapping("/admin/topic")
public class CmsTopicController {
    @Autowired
    ICmsTopicService cmsTopicService;

    @ApiOperation(value = "查询专题")
    @GetMapping("/list")
    public CommonResult listTopic(Integer page, Integer pageSize) {
        return CommonResult.success(cmsTopicService.listTopic(page, pageSize));
    }

    @ApiOperation(value = "根据专题id查询专题")
    @GetMapping("/selectById")
    public CommonResult<CmsTopic> selectById(Long id) {
        return CommonResult.success(cmsTopicService.selectById(id));
    }


    @ApiOperation("增加专题")
    @PostMapping("/insertTopic")
    public CommonResult<Integer> insertTopic(CmsTopic cmsTopic) {
        return CommonResult.success(cmsTopicService.insertTopic(cmsTopic));
    }

    @ApiOperation("修改专题“")
    @PutMapping("/updateTopic")
    public CommonResult<Integer> updateTopic(CmsTopic cmsTopic) {
        return CommonResult.success(cmsTopicService.updateTopic(cmsTopic));
    }

    @ApiOperation("删除专题")
    @DeleteMapping("deleteTopic")
    public CommonResult<Integer> deleteTopic(Long id) {

        int val = -1;
        try {
            val = cmsTopicService.deleteTopic(id);
            if (val == 1) {
                return CommonResult.success(val);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.FAILED);
        }
        return CommonResult.fail(-1, "删除失败");
    }


}
