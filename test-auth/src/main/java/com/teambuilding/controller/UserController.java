package com.teambuilding.controller;

import com.teambuilding.commons.AjaxResult;
import com.teambuilding.request.LoginRequest;
import com.teambuilding.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private SysUserService userService;

    @RequestMapping("/sys/user/login")
    public AjaxResult login(@RequestBody LoginRequest request){
        return userService.login(request);
    }

}
