package com.mt.portalcms.web.admin;

import com.mt.portalcms.common.base.CommonResult;
import com.mt.portalcms.common.enums.ResponseCode;
import com.mt.portalcms.pojo.CmsArticle;
import com.mt.portalcms.pojo.vo.CmsArticleVo;
import com.mt.portalcms.service.ICmsArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "管理员文章接口")
@RestController("articleAdmin")
@RequestMapping("/admin/article")
public class CmsArticleController {
    @Autowired
    ICmsArticleService cmsArticleService;

    @ApiOperation(value = "查询文章", notes = " 1:表示交通解决方案")
    @GetMapping("/list/{topicId}")
    public CommonResult listArticle(@PathVariable("topicId") Long topicId) {
        CommonResult<List<CmsArticle>> success = null;
        try {
            success = CommonResult.success(cmsArticleService.listArticle(topicId));
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.FAILED);
        }
        return success;
    }

    @ApiOperation(value = "根据文章id查询文章")
    @GetMapping("/findById")
    public CommonResult<CmsArticle> findById(Long id) {
        return CommonResult.success(cmsArticleService.selectById(id));
    }

    @ApiOperation(value = "增加文章")
    @PostMapping("insertArticle")
    public CommonResult<Integer> insertArticle(@RequestBody CmsArticleVo cmsArticleVo, Long articleId) {
        Integer integer = 0;
        try {
            integer = cmsArticleService.insertArticle(cmsArticleVo);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.FAILED);
        }
        return CommonResult.success(integer);
    }

    /**
     * 更新未完善
     *
     * @param cmsArticleVo
     * @return
     */
    @ApiOperation(value = "修改用户", notes = "传入articleId和文章内容")
    @PutMapping("/updateArticle")
    public CommonResult<Integer> updateArticle(@RequestBody CmsArticleVo cmsArticleVo) {
        //保证开启的数量为指定个数


        Integer integer = 0;
        try {
            integer = cmsArticleService.updateArticle(cmsArticleVo);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.FAILED);
        }
        if (integer == 1) {
            return CommonResult.success(integer);
        }
        return CommonResult.fail(-1, "更新失败");
    }

    @ApiOperation(value = "删除用户", notes = "传入文章id")
    @DeleteMapping("/deleteArticle/{id}")
    public CommonResult<Integer> deleteArticle(@PathVariable("id") Long id) {
        int val = -1;
        try {
            val = cmsArticleService.deleteArticle(id);
            if (val != 1) {
                return CommonResult.fail(-1, "删除失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.FAILED);
        }
        return CommonResult.success(val);
    }
}
