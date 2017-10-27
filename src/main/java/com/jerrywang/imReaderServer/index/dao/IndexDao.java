package com.jerrywang.imReaderServer.index.dao;

import com.jerrywang.imReaderServer.index.model.ConsumeRecord;

import java.util.List;
import java.util.Map;

/**
 * @author jerrywang
 * @create 2017/1/22.
 */
public interface IndexDao {

    /**
     * @Description 根据用户名获取所在项目列表
     * @author JerryWang
     * @date 2017/1/22 19:56
     * @param username
     * @return
     */
    List<Map<String, String>> getObjectsByUser(String username);

    /**
     * @Description 获取最新数据数量
     * @author JerryWang
     * @date 2017/8/3 18:26
     * @param param
     * @return
     */
    String countNew(Map<String, String> param);

    /**
     * @Description 获取最新数据
     * @author JerryWang
     * @date 2017/8/4 14:13
     * @param param
     * @return
     */
    List<Map<String,String>> getNew(Map<String, String> param);

    /**
     * @Description 根据人员编号修改显示状态字段
     * @author JerryWang
     * @date 2017/8/5 14:15
     * @param param
     */
    void updateDisplayStateByUser(Map<String, String> param);

    /**
     * @Description 新增消费详情
     * @author JerryWang
     * @date 2017/8/13 20:42
     * @param param
     * @return
     */
    void add(ConsumeRecord param);

    /**
     * @Description 修改消费详情
     * @author JerryWang
     * @date 2017/8/13 20:43
     * @param param
     */
    void upd(ConsumeRecord param);

    /**
     * @Description 获取余额信息
     * @author JerryWang
     * @date 2017/8/14 15:21
     * @param param
     * @return
     */
    Float getBalance(Map<String, String> param);

    /**
     * @Description 获取今日记账信息
     * @author JerryWang
     * @date 2017/8/14 15:28
     * @param param
     * @return
     */
    Map<String,String> getAccountInfo(Map<String, String> param);

    void checkBalance(ConsumeRecord param);

    /**
     * @Description 获取列表信息
     * @author JerryWang
     * @date 2017/8/15 10:38
     * @param param
     * @return
     */
    List<Map<String,String>> queryList(Map<String, String> param);
}
