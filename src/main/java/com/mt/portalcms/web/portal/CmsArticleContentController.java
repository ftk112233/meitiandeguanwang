package com.mt.portalcms.web.portal;

import com.mt.portalcms.pojo.CmsArticleContent;
import com.mt.portalcms.service.ICmsArticleContentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "门户文章内容接口")
@RestController
@RequestMapping("/articleContent")
public class CmsArticleContentController {
    @Autowired
    ICmsArticleContentService cmsArticleContentService;

    @ApiOperation(value = "根据文章id查询文章内容", notes = "传入文章id")
    @GetMapping("/selectByArticleId")
    public CmsArticleContent findByArticleId(Long articleId) {
        return cmsArticleContentService.findByArticleId(articleId);
    }
}
