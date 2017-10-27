package com.jerrywang.imReaderServer.index.service;

import com.jerrywang.imReaderServer.index.model.ConsumeRecord;
import com.jerrywang.comm.model.Query;

import java.util.List;
import java.util.Map;

/**
 * @author jerrywang
 * @create 2017/1/22.
 */
public interface IndexService {

    public List<Map<String, String>> getObjectsByUser(String username);

    /**
     * @Description 获取最新数据数量
     * @author JerryWang
     * @date 2017/8/3 18:22
     * @param param
     * @return
     */
    String countNew(Map<String, String> param);

    /**
     * @Description 获取最新数据
     * @author JerryWang
     * @date 2017/8/4 14:12
     * @param param
     * @return
     */
    List<Map<String,String>> getNew(Map<String, String> param);

    /**
     * @Description 获取首页消费详情
     * @author JerryWang
     * @date 2017/8/13 20:40
     * @param
     * @return
     */
    Query queryList(Map<String, String> param);


    /**
     * @Description 保存消费详情
     * @author JerryWang
     * @date 2017/8/13 20:41
     * @param param
     * @return
     */
    String save(ConsumeRecord param);

    /**
     * @Description 获取记账信息
     * @author JerryWang
     * @date 2017/8/14 15:10
     * @param param
     * @return
     */
    Map<String,String> getInfo(Map<String, String> param);

    /**
     * @Description 获取余额信息
     * @author JerryWang
     * @date 2017/8/14 16:56
     * @param param
     * @return
     */
    Map<String,String> getBalance(Map<String, String> param);
}
