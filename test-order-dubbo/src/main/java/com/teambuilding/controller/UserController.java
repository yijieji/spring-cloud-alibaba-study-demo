package com.teambuilding.controller;


import com.teambuilding.IUserService;
import com.teambuilding.commons.AjaxResult;
import com.teambuilding.pojo.User;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @DubboReference
    private IUserService userService;

    @RequestMapping("/user/list")
    public AjaxResult userList(){
        AjaxResult ajaxResult = userService.selectAll();
        return ajaxResult;
    }

    @RequestMapping("/user/getById")
    public AjaxResult selectById(@RequestParam("id") Integer id){
        AjaxResult ajaxResult = userService.selectById(id);
        return ajaxResult;
    }

    @RequestMapping("/user/delete")
    public AjaxResult delete(@RequestParam("id")Integer id){
        System.out.println("id = " + id);
        AjaxResult ajaxResult = userService.deleteUser(id);
        return ajaxResult;
    }
    @RequestMapping("/user/update")
    public AjaxResult update(@RequestBody User user){
        AjaxResult ajaxResult = userService.updateUser(user);
        return ajaxResult;
    }
    @RequestMapping("/user/add")
    public AjaxResult addUser(@RequestBody User user){
        AjaxResult ajaxResult = userService.save(user);
        return ajaxResult;
    }

}
