package com.jerrywang.imReaderServer.index.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jerrywang.imReaderServer.index.dao.IndexDao;
import com.jerrywang.imReaderServer.index.model.ConsumeRecord;
import com.jerrywang.comm.model.Query;
import com.jerrywang.comm.util.CommUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author jerrywang
 * @create 2017/1/22.
 */
@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    IndexDao indexDao;

    public List<Map<String, String>> getObjectsByUser(String username){
        return indexDao.getObjectsByUser(username);
    }

    /**
     * @param param
     * @return
     * @Description 获取最新数据数量
     * @author JerryWang
     * @date 2017/8/3 18:22
     */
    public String countNew(Map<String, String> param) {
        return indexDao.countNew(param);
    }

    public List<Map<String, String>> getNew(Map<String, String> param) {
        return indexDao.getNew(param);
    }

    /**
     * @param
     * @return
     * @Description 获取首页消费详情
     * @author JerryWang
     * @date 2017/8/13 20:40
     */
    public Query queryList(Map<String, String> param) {

        PageHelper.startPage(Integer.parseInt(param.get("pageNum")),Integer.parseInt(param.get("pageSize")));
        List<Map<String, String>> list = indexDao.queryList(param);
        Query query = new Query();
        query.setList(list);
        query.setPageNum(Integer.parseInt(param.get("pageNum")));
        query.setPageSize(Integer.parseInt(param.get("pageSize")));
        query.setTotal(((Page)list).getTotal());

        return query;

    }

    /**
     * @param param
     * @return
     * @Description 保存消费详情
     * @author JerryWang
     * @date 2017/8/13 20:41
     */
    public String save(ConsumeRecord param) {

        try {
            param.setMoney(param.getBreakfast() + param.getLunch() + param.getDinner() + param.getOther());
            indexDao.checkBalance(param);
            // 如果uuid为空,插入
            if ("".equals(param.getUuid())) {
                param.setUuid(CommUtil.getUUID());
                indexDao.add(param);
            }else {// 修改
                indexDao.upd(param);
            }

            return param.getUuid();
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
    }

    /**
     * @Description 获取记账信息
     * @author JerryWang
     * @date 2017/8/14 15:11
     * @param param
     * @return
     */
    public Map<String, String> getInfo(Map<String, String> param) {
        Map<String, String> result = indexDao.getAccountInfo(param);
        if (result == null){
            result = new HashMap<>();
        }
        return result;
    }

    /**
     * @Description 获取余额信息
     * @author JerryWang
     * @date 2017/8/14 16:56
     * @param param
     * @return
     */
    public Map<String, String> getBalance(Map<String, String> param) {
        // 获取余额信息
        Float balance = indexDao.getBalance(param);

        Map<String, String> returnMap = new HashMap<>();
        returnMap.put("balance", String.valueOf(balance));
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        returnMap.put("today", sdf.format(now));
        return returnMap;
    }
}
