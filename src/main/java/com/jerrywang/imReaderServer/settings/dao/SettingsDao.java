package com.jerrywang.imReaderServer.settings.dao;

import java.util.Map;

/**
 * @author jerrywang
 * @create 2017/8/26.
 */
public interface SettingsDao {

    /**
     * @Description 校验密码
     * @author JerryWang
     * @date 2017/8/26 17:08
     * @param param
     * @return
     */
    int checkPassword(Map<String, String> param);

    /**
     * @Description 保存新密码
     * @author JerryWang
     * @date 2017/8/26 19:18
     * @param param
     */
    void saveNewPassword(Map<String, String> param);
}
