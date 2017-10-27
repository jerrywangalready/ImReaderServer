package com.jerrywang.imReaderServer.register.service;

import com.jerrywang.comm.util.CommUtil;
import com.jerrywang.imReaderServer.register.dao.RegisterDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author jerrywang
 * @create 2017/9/28.
 */
@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    RegisterDao registerDao;

    /**
     * @param param
     * @return
     * @Description 注册
     * @author JerryWang
     * @date 2017/9/28 23:16
     */
    public String doRegister(Map<String, String> param) {
        param.put("uuid", CommUtil.getUUID());
        try {
            registerDao.save(param);
            return "true";
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
    }
}
