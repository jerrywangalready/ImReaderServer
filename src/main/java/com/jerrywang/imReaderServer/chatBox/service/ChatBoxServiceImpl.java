package com.jerrywang.imReaderServer.chatBox.service;

import com.jerrywang.imReaderServer.chatBox.dao.ChatBoxDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author jerrywang
 * @create 2017/10/11.
 */
@Service
public class ChatBoxServiceImpl implements ChatBoxService {

    @Autowired
    ChatBoxDao chatBoxDao;

    /**
     * @param param
     * @Description 保存声音文件信息
     * @author JerryWang
     * @date 2017/10/11 21:23
     */
    public void saveSoundsInfo(Map<String, Object> param) {
        chatBoxDao.saveSoundsInfo(param);
    }
}
