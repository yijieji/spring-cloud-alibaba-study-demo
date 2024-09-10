package com.teambuilding;

import com.teambuilding.commons.AjaxResult;
import com.teambuilding.pojo.User;

public interface IUserService {
    /**
     * 添加用户功能
     * @param user
     * @return
     */
    AjaxResult save(User user);
    /**
     * 查询用户
     * @param user
     * @return
     */
    AjaxResult findByUser(User user);

    /**
     * 更新用户功能
     * @param user
     * @return
     */
    AjaxResult updateUser(User user);

    /**
     * 根据用户id删除用户
     * @param userid
     */
    AjaxResult deleteUser(Integer userid);

    AjaxResult selectById(Integer id);

    AjaxResult selectAll();
}
