package com.mt.portalcms.common.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.mt.portalcms.pojo.UmsUser;

import java.io.UnsupportedEncodingException;


public class createToken {
    public static String getToken(UmsUser user) throws UnsupportedEncodingException {
        String token = "";
        token = JWT.create().withAudience(user.getId().toString()).sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}
