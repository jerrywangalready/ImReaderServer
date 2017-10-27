package com.jerrywang.imReaderServer.register.dao;

import java.util.Map;

/**
 * @author jerrywang
 * @create 2017/9/28.
 */
public interface RegisterDao {


    /**
     * @Description 保存
     * @author JerryWang
     * @date 2017/9/28 23:18
     * @return
     */
    void save(Map<String, String> param);
}
