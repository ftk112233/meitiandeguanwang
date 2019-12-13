package com.mt.portalcms.common.aop;

import com.auth0.jwt.JWT;
import com.mt.portalcms.common.exception.LoginException;
import com.mt.portalcms.common.util.RedisUtil;
import com.mt.portalcms.mapper.UmsUserMapper;
import com.mt.portalcms.pojo.UmsUser;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Aspect
@Component
public class Aspecttoken {
    @Autowired
    private UmsUserMapper userMapper;
    @Autowired
    private RedisUtil redis;

    //用来获取前台请求头中的所有信息
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpServletResponse response;

    //定义切入点
    @Pointcut("execution (* com.mt.portalcms.web.admin..*.*(..))")
    public void controllerAspect() {
    }

    //前置通知：在连接点之前执行的通知
    @Before("controllerAspect()")
    public Boolean doBefore() throws IOException {
        //获取前台请求参数
        String token = request.getHeader("token");// 从 http 请求头中取出 token
        if (token == null || !token.equals(redis.get("token"))) {
            throw new LoginException(-1, "您没有登陆，请先登陆");
        } else {
            String userid = JWT.decode(token).getAudience().get(0);
            UmsUser umsUser = new UmsUser();
            umsUser.setId(Long.parseLong(userid));
            if (userMapper.selectOne(umsUser) == null) {
                throw new LoginException(-1, "您没有登陆，请先登陆");
            }
            return true;
        }
    }
}

//    public void responseError(HttpServletResponse response)
//            throws IOException, UnsupportedEncodingException {
//        OutputStream out=null;
//        try{
//            response.setCharacterEncoding("utf-8");
//            response.setContentType("text/json");
//           out = response.getOutputStream();
//            out.write(JSON.toJSONString(CommonResult.fail(-1,"请重新登录")).getBytes());
//            out.flush();
//        } finally{
//            if(out!=null){
//                out.close();
//            }
//        }
//    } 此处是返回给前端的回显错误信息代码，因为用了自定义异常处理设置所以不再需要

