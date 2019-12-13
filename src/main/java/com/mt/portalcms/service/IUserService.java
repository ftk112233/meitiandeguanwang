package com.mt.portalcms.service;

import com.mt.portalcms.pojo.UmsUser;

/**
 * 用户业务接口
 * @author g
 * @date 2019-11-16 15:31
 */
public interface IUserService {

    int insert(UmsUser user);

    UmsUser login(String username);

}
