package com.jerrywang.imReaderServer.index.controller;

import com.jerrywang.imReaderServer.index.model.ConsumeRecord;
import com.jerrywang.comm.model.Query;
import com.jerrywang.comm.util.service.CommService;
import com.jerrywang.imReaderServer.index.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author jerrywang
 * @create 2017/1/10.
 */
@Controller
@RequestMapping("/index")
public class IndexController {
    @Autowired
    IndexService indexService;
    @Autowired
    CommService commService;

    /**
     * @Description 首页初始化
     * @author JerryWang
     * @date 2017/1/16 11:18
     * @return
     */
    @RequestMapping(value = "/index.do")
    public String index(){
        return "/index/index";
    }

    /**
     * @Description 退出功能
     * @author JerryWang
     * @date 2017/1/16 11:17
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/logout.do")
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "true";
    }

    /**
     * @Description 根据用户名获取所在项目信息
     * @author JerryWang
     * @date 2017/1/22 20:19
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getObjects", method = RequestMethod.POST)
    public List<Map<String, String>> getObjectsByUser(HttpServletRequest request){
        String username = request.getParameter("username");
        return indexService.getObjectsByUser(username);
    }

    @RequestMapping("/countNew")
    public @ResponseBody String countNew(String obj, String dt){
        Map<String, String> param = new HashMap<>();
        param.put("obj", obj);
        param.put("dt", dt);
        param.put("username", commService.getLoginInfo().getLoginUser());
        return indexService.countNew(param);
    }

    @RequestMapping("/getNew")
    public @ResponseBody Map<String, Object> getNew(@RequestBody Map<String, String> param){
        param.put("username", commService.getLoginInfo().getLoginUser());
        Map<String, Object> map = new HashMap<>();
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        map.put("dt", sdf.format(now));
        map.put("query", indexService.getNew(param));
        return map;
    }

    @RequestMapping("/init")
    public String indexInit(){
        return "/index/indexInit";
    }

    @RequestMapping("/save")
    public @ResponseBody String save(@RequestBody Map<String, String> param) {
        ConsumeRecord consumeRecord = new ConsumeRecord();
        consumeRecord.setUuid(param.get("uuid"));
        consumeRecord.setUserId(commService.getLoginInfo().getLoginUser());
        consumeRecord.setBreakfast(Float.parseFloat("".equals(param.get("breakfast")) ? "0":param.get("breakfast")));
        consumeRecord.setLunch(Float.parseFloat("".equals(param.get("lunch")) ? "0":param.get("lunch")));
        consumeRecord.setDinner(Float.parseFloat("".equals(param.get("dinner")) ? "0":param.get("dinner")));
        consumeRecord.setOther(Float.parseFloat("".equals(param.get("other")) ? "0":param.get("other")));
        consumeRecord.setCardId(param.get("cardId"));
        consumeRecord.setRecordTime(param.get("recordTime"));
        consumeRecord.setRemark(param.get("remark"));
        return indexService.save(consumeRecord);
    }

    @RequestMapping("/getBalance")
    public @ResponseBody Map<String, String> getBalance(String cardId) {
        Map<String, String> param = new HashMap<>();
        param.put("cardId", cardId);
        param.put("userId", commService.getLoginInfo().getLoginUser());
        return indexService.getBalance(param);
    }

    @RequestMapping("/getInfoByDate")
    public @ResponseBody Map<String, String> getInfoByDate(String cardId, String recordTime) {
        Map<String, String> param = new HashMap<>();
        param.put("cardId", cardId);
        param.put("userId", commService.getLoginInfo().getLoginUser());
        param.put("recordTime", recordTime);
        return indexService.getInfo(param);
    }

    /**
     * @Description 获取列表信息
     * @author JerryWang
     * @date 2017/8/15 11:00
     * @param
     * @return
     */
    @RequestMapping("/queryList")
    public @ResponseBody Query queryList(@RequestBody Map<String, String> param) {
        param.put("userId", commService.getLoginInfo().getLoginUser());
        return indexService.queryList(param);
    }

}
