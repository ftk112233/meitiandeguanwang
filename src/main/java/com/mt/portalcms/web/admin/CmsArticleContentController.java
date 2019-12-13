package com.mt.portalcms.web.admin;


import com.mt.portalcms.common.base.CommonResult;
import com.mt.portalcms.pojo.CmsArticleContent;
import com.mt.portalcms.service.ICmsArticleContentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "管理员文章内容接口")
@RestController("articleContentAdmin")
@RequestMapping("/admin/articleContent")
public class CmsArticleContentController {
    @Autowired
    ICmsArticleContentService cmsArticleContentService;

    @ApiOperation(value = "根据文章id查询文章内容", notes = "传入文章id")
    @GetMapping("/selectByArticleId")
    public CmsArticleContent findByArticleId(Long articleId) {
        return cmsArticleContentService.findByArticleId(articleId);
    }

    @ApiOperation(value = "根据文章内容id查询文章内容", notes = "传入文章内容id")
    @GetMapping("/selectByArticleContentId")
    public CmsArticleContent findByArticleContent(Long id) {
        return cmsArticleContentService.findByArticleContentId(id);
    }


    @ApiOperation(value = "增加文章内容")
    @PostMapping("/insertArticleContent")
    public CommonResult<Integer> insertArticleContent(CmsArticleContent cmsArticleContent) {
        return CommonResult.success(cmsArticleContentService.insertArticleContent(cmsArticleContent));
    }

    @ApiOperation(value = "修改文章内容")
    @PutMapping("/updateArticleContent")
    public CommonResult<Integer> updateArticleContent(CmsArticleContent cmsArticleContent) {
        return CommonResult.success(cmsArticleContentService.updateArticleContent(cmsArticleContent));
    }

    @ApiOperation(value = "删除文章内容")
    @DeleteMapping("/deleteArticleContent")
    public CommonResult<Integer> deleteArticleContent(Long id) {
        return CommonResult.success(cmsArticleContentService.deleteArticleContent(id));
    }


}
