package com.mt.portalcms.web.admin;

import com.mt.portalcms.common.base.CommonResult;
import com.mt.portalcms.service.NewsService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("newsAdmin")
@RequestMapping("/admin/news")
@Api(tags = "管理员新闻及动态接口")
public class NewsController {
    @Autowired
    NewsService newsService;

    @GetMapping("/list")
    public CommonResult list(@RequestParam("page") Integer page,
                             @RequestParam("pageSize") Integer pageSize,
                             @RequestParam("topicId") Long topicId) {

        return CommonResult.success(newsService.list(page, pageSize, topicId));
    }
}
