package com.mt.portalcms.common.config.shiro;

import com.mt.portalcms.common.util.RedisUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author g
 * @date 2019-11-01 9:22
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    RedisUtil redisUtil;
    /*@Autowired
    UserService userService;*/

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        /*// 获取controller传来的登陆信息
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        String username = token.getUsername();
        // 获取用户
        User user = userService.findById(username);
        if (user == null) {
            throw new AuthenticationException("用户名不存在");
        }
        String password = new String(token.getPassword());

        if(!password.equals(user.getPassword())) {
            throw new AuthenticationException("用户名或密码错误");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
*/
        return null;
    }
}
