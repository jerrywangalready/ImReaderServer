package com.jerrywang.imReaderServer.settings.service;

import com.jerrywang.imReaderServer.settings.dao.SettingsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jerrywang
 * @create 2017/8/26.
 */
@Service
public class SettingsServiceImpl implements SettingsService {

    @Autowired
    SettingsDao settingsDao;

    /**
     * @param param
     * @return
     * @Description 校验密码
     * @author JerryWang
     * @date 2017/8/26 17:01
     */
    public Map<String, Object> checkPassword(Map<String, String> param) {
        int num = settingsDao.checkPassword(param);
        Map<String, Object> result = new HashMap<>();
        if(num == 0){
            result.put("result", false);
            result.put("info", "密码输入错误!");
        }else {
            result.put("result", true);
            result.put("info", "");
        }
        return result;
    }

    /**
     * @param param
     * @return
     * @Description 保存新密码
     * @author JerryWang
     * @date 2017/8/26 19:16
     */
    public String saveNewPassword(Map<String, String> param) {
        try {
            settingsDao.saveNewPassword(param);
            return "true";
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
    }

}
