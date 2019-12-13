package com.mt.portalcms.web.portal;

import com.mt.portalcms.common.base.CommonResult;
import com.mt.portalcms.common.enums.ResponseCode;
import com.mt.portalcms.pojo.CmsArticle;
import com.mt.portalcms.service.ICmsArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "门户文章接口")
@RestController
@RequestMapping("/article")
public class CmsArticleController {
    @Autowired
    ICmsArticleService cmsArticleService;

    @ApiOperation(value = "分页查询文章", notes = "传入专题id及分页参数")
    @GetMapping("/list")
    public CommonResult<List<CmsArticle>> listArticle(Long topicId) {

        try {
            List<CmsArticle> cmsArticles = cmsArticleService.selectArticle(topicId);
            return CommonResult.success(cmsArticles);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.FAILED);
        }

    }

}
