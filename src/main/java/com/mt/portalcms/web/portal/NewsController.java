package com.mt.portalcms.web.portal;

import com.mt.portalcms.common.base.CommonResult;
import com.mt.portalcms.pojo.CmsArticle;
import com.mt.portalcms.service.ICmsArticleService;
import com.mt.portalcms.service.NewsService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "门户新闻接口")
@RestController
@RequestMapping("/new")
public class NewsController {
    @Autowired
    NewsService newsService;

    @GetMapping("/select")
    public CommonResult select(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                               @RequestParam(value = "pageSize", required = false, defaultValue = "4") Integer pageSize, Long topicId) {
        return CommonResult.success(newsService.select(page, pageSize, topicId));
    }
    @GetMapping("findById")
    public CommonResult<List<CmsArticle>> findById(@RequestParam("id") Long id, @RequestParam("topicId") Long topicId){
        return CommonResult.success(newsService.findById(id,topicId));
    }
}
