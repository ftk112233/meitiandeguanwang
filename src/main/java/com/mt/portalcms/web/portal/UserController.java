package com.mt.portalcms.web.portal;

import com.mt.portalcms.common.base.CommonResult;
import com.mt.portalcms.common.util.RedisUtil;
import com.mt.portalcms.pojo.UmsUser;
import com.mt.portalcms.service.IUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

import static com.mt.portalcms.common.util.createToken.getToken;

//import static com.mt.portalcms.common.util.createToken.getToken;

/**
 * @author g
 * @date 2019-11-16 15:34
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;
    @Autowired
    private RedisUtil redis;

//    @ApiOperation(value = "添加用户")
//    @PostMapping("/add")
//    public CommonResult<Integer> add(UmsUser user) {
//        return CommonResult.success(userService.insert(user));
//    }

    @ApiOperation(value = "管理员登陆", notes = "传递username和password")
    @PostMapping("/login")
    public CommonResult login(String username, String password) {
        UmsUser user = userService.login(username);
        String token = null;
        if (user == null) {
            return CommonResult.fail(-1, "用户名或者密码错误");
        } else {
            if (!user.getPassword().equals(password)) {
                return CommonResult.fail(-1, "用户名或者密码错误");
            }
            try {
                token = getToken(user);
                redis.set("token", token, 60 * 60 * 24);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return CommonResult.success(token);

    }

    @ApiOperation(value = "管理员退出登陆")
    @PostMapping("/loginOut")
    public CommonResult<String> loginOut() {
        redis.del("token");
        return CommonResult.success("退出成功");
    }


}
