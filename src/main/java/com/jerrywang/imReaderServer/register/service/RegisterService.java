package com.jerrywang.imReaderServer.register.service;

import java.util.Map; /**
 * @author jerrywang
 * @create 2017/9/28.
 */
public interface RegisterService {

    /**
     * @Description 注册
     * @author JerryWang
     * @date 2017/9/28 23:27
     * @param param
     * @return
     */
    String doRegister(Map<String, String> param);
}
