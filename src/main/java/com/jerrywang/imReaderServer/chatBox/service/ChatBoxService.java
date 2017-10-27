package com.jerrywang.imReaderServer.chatBox.service;

import java.util.Map;

/**
 * @author jerrywang
 * @create 2017/10/11.
 */
public interface ChatBoxService {

    /**
     * @Description 保存声音文件信息
     * @author JerryWang
     * @date 2017/10/11 21:23
     * @param param
     */
    void saveSoundsInfo(Map<String, Object> param);
}
