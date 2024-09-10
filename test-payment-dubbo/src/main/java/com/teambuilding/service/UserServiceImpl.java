package com.teambuilding.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.teambuilding.IUserService;
import com.teambuilding.commons.AjaxResult;
import com.teambuilding.mapper.UserMapper;
import com.teambuilding.pojo.User;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.teambuilding.commons.AjaxResult.success;

/**
 * 添加用户业务
 */
@DubboService
public class UserServiceImpl implements IUserService {


    @Autowired
    private UserMapper userMapper;


    /**
     * 添加用户
     * @param user
     * @return
     */
    @Override
    public AjaxResult save(User user) {

        // 添加用户
        int insert = userMapper.insert(user);
        // 判断是否添加成功
        if (insert > 0){
            // 结果编码
            return AjaxResult.success();

        }else {
            return AjaxResult.error("添加异常，请联系管理员");

        }
    }

    /**
     * 查询用户
     * @param user
     * @return
     */
    @Override
    public AjaxResult findByUser(User user) {
        // 1、条件构造器
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        lqw.eq(user.getId() != null, User::getId, user.getId());
        lqw.eq(user.getName() != null, User::getName, user.getName());
        lqw.eq(user.getAge() != null, User::getAge, user.getAge());
        // 2、查询用户
        List<User> users = userMapper.selectList(lqw);
        return AjaxResult.success(users);
    }

    /**
     * 更新用户
     * @param user
     * @return
     */
    @Override
    public AjaxResult updateUser(User user) {
        // 1、条件构造器
        LambdaUpdateWrapper<User> uluw = new LambdaUpdateWrapper<>();
        uluw.set(user.getName() != null ,User::getName,user.getName());
        uluw.set(user.getAge() != null ,User::getAge,user.getAge());
        if (user.getId() == null){
            return AjaxResult.error(500,"用户id为空~");
        }
        uluw.eq(User::getId,user.getId());
        // 更新用户
        int update = userMapper.update(null, uluw);
        if (update > 0){
            return AjaxResult.success();
        }else {
            return AjaxResult.error(500,"更新失败~");
        }
    }

    /**
     * 根据用户id去删除用户
     * @param id
     * @return
     */
    @Override
    public AjaxResult deleteUser(Integer id) {
//        CommonResult commonResult = new CommonResult();
        if (id == null){
            return AjaxResult.error(500,"用户id为空~");

        }
        // 1、根据用户id删除用户
        int i = userMapper.deleteById(id);
        if( i > 0){
            return AjaxResult.success();
        }else {
            return AjaxResult.error(500,"删除失败");
        }

    }

    @Override
    public AjaxResult selectById(Integer id) {
        User user = userMapper.selectById(id);
        if (user != null){
            return AjaxResult.success();
        }
        return AjaxResult.error(500,"查询失败");
    }

    @Override
    public AjaxResult selectAll() {
        List<User> users = userMapper.selectList(null);
        if (users.size() > 0) {
            return AjaxResult.success();
        }
        return AjaxResult.error();
    }
}
