package com.jerrywang.imReaderServer.login.service;

import com.jerrywang.imReaderServer.login.dao.LoginDao;
import com.jerrywang.imReaderServer.login.model.UserToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDao loginDao;

	/**
	 * @description 校验登录权限
	 * @param username
	 * @param password
	 * @return
	 */
	public UserToken checkUser(String username, String password){
		Map<String, String> param = new HashMap<>();
		param.put("username",username);
		param.put("password",password);

		UserToken user = null;
		try {
//			user = loginDao.checkUser(param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	/**
	 * @param param
	 * @return
	 * @Description 校验是否已经注册
	 * @author JerryWang
	 * @date 2017/9/28 22:04
	 */
	public String checkRegister(Map<String, String> param) {
		List<String> list = loginDao.checkRegister(param);
		if(list.size() > 0){
			return list.get(0);
		}else {
			return "";
		}

	}

	/**
	 * @param openId
	 * @return
	 * @Description 获取系统内编号
	 * @author JerryWang
	 * @date 2017/10/23 19:35
	 */
	public String getUserId(String openId) {
		return loginDao.getUserId(openId);
	}

}
