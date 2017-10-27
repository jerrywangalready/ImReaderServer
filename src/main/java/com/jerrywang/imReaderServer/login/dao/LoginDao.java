package com.jerrywang.imReaderServer.login.dao;


import com.jerrywang.imReaderServer.login.model.UserToken;

import java.util.List;
import java.util.Map;

public interface LoginDao {

    /**
     * @Description 校验注册情况
     * @author JerryWang
     * @date 2017/9/28 22:13
     * @param param
     * @return
     */
    List<String> checkRegister(Map<String, String> param);

    /**
     * @Description 获取系统内编号
     * @author JerryWang
     * @date 2017/10/23 19:36
     * @param openId
     * @return
     */
    String getUserId(String openId);
}
