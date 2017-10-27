package com.jerrywang.comm.util.service;

import com.jerrywang.comm.model.LoginInfo;

import java.util.List;
import java.util.Map;

/**
 * @author jerrywang
 */
public interface CommService extends BaseService{

    /**
     * @Description 插入操作日志
     * @author JerryWang
     * @date 2017/5/11 21:22
     * @param businessId
     * @param operateDetail
     * @param remark
     */
    void insertIssueRecord(String businessId, String operateDetail, String remark);

    /**
     * @Description 根据businessId获取操作日志
     * @author JerryWang
     * @date 2017/5/11 21:20
     * @param businessId
     * @return
     */
    List<Map<String, String>> getIssueRecord(String businessId);

    /**
     * @Description 获取登录人信息
     * @author JerryWang
     * @date 2017/7/9 19:06
     * @return
     */
    LoginInfo getLoginInfo();

    /**
     * @Description 获取配置信息
     * @author JerryWang
     * @date 2017/6/7 16:03
     * @return
     */
    List<Map<String, String>> getProperties();
}
