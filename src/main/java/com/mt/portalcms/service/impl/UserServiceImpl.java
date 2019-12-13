package com.mt.portalcms.service.impl;

import com.mt.portalcms.mapper.UmsUserMapper;
import com.mt.portalcms.pojo.UmsUser;
import com.mt.portalcms.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户业务实现类
 *
 * @author g
 * @date 2019-11-16 15:32
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UmsUserMapper userMapper;

    @Override
    public int insert(UmsUser user) {
        return userMapper.insert(user);
    }

    @Override
    public UmsUser login(String username) {
        UmsUser umsUser = new UmsUser();
        umsUser.setUsername(username);
        return userMapper.selectOne(umsUser);
    }

}

