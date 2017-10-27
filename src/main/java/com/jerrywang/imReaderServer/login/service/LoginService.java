package com.jerrywang.imReaderServer.login.service;


import com.jerrywang.imReaderServer.login.model.UserToken;

import java.util.Map;

public interface LoginService {

	/**
	 * @Description 校验用户是否可以登录
	 * @param username 账号
	 * @param password 密码
	 * @return 
	 * @author JerryWang
	 * @date 2017/1/15 10:30
	 */
	UserToken checkUser(String username, String password);

	/**
	 * @Description 校验是否已经注册
	 * @author JerryWang
	 * @date 2017/9/28 22:04
	 * @param param
	 * @return
	 */
	String checkRegister(Map<String, String> param);

	/**
	 * @Description 获取系统内编号
	 * @author JerryWang
	 * @date 2017/10/23 19:35
	 * @param openId
	 * @return
	 */
	String getUserId(String openId);
}
