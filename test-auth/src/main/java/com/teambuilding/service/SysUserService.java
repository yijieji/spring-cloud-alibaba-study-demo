package com.teambuilding.service;



import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.teambuilding.commons.AjaxResult;
import com.teambuilding.request.LoginRequest;
import com.teambuilding.utils.JwtUtils;
import org.springframework.stereotype.Service;

@Service
public class SysUserService {

    public AjaxResult login(LoginRequest loginRequest){
        // 1、用户名或者密码校验
        if (StringUtils.isEmpty(loginRequest.getUsername()) || StringUtils.isEmpty(loginRequest.getPassword()) ){
            return AjaxResult.error("用户名或者密码为空");
        }
        // 2、判断用户名和密码是否正确
        //TODO 数据库操作
        if (loginRequest.getUsername().equals("admin")&& loginRequest.getPassword().equals("123456")){
            // 颁发登录token
            String token = JwtUtils.sign(1001L, "admin");
            return AjaxResult.success(token);
        }

        return AjaxResult.error("用户名或者密码不对");
    }
}
