package com.mt.portalcms.web;

import com.mt.portalcms.common.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;

/**
 * controller通用方法
 * @author g
 * @date 2019-11-16 13:32
 */
@Controller
public class BaseController {
    @Autowired
    RedisUtil redisUtil;

    /**
     * 获取当前登陆用户
     */
    public Object getCurrentUser(HttpServletRequest request) {
        String token = request.getHeader("token");
        return redisUtil.get(token);
    }

    /**
     * 获取项目类路径
     * @throws FileNotFoundException
     */
    public static String getClasspath() throws FileNotFoundException {
        return ResourceUtils.getURL("classpath:").getPath();
    }
}
