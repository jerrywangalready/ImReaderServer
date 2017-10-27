package com.jerrywang.imReaderServer.settings.service;

import java.util.Map;

/**
 * @author jerrywang
 * @create 2017/8/26.
 */
public interface SettingsService {

    /**
     * @Description 校验密码
     * @author JerryWang
     * @date 2017/8/26 17:01
     * @param param
     * @return
     */
    Map<String, Object> checkPassword(Map<String, String> param);

    /**
     * @Description 保存新密码
     * @author JerryWang
     * @date 2017/8/26 19:16
     * @param param
     * @return
     */
    String saveNewPassword(Map<String, String> param);
}
