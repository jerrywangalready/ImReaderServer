package com.jerrywang.imReaderServer.login.controller;

import com.alibaba.fastjson.JSON;
import com.jerrywang.comm.util.HttpRequest;
import com.jerrywang.imReaderServer.login.model.OpenId;
import com.jerrywang.imReaderServer.login.model.UserToken;
import com.jerrywang.imReaderServer.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.json.Json;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jerrywang
 * @create 2017/1/7.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/login.do")
    public void index(Model model, HttpServletRequest request){
    }

    @ResponseBody
    @RequestMapping(value = "/doLogin.do",method= RequestMethod.POST)
    public String doLogin(HttpServletRequest request, HttpServletResponse httpServletResponse){
        String username = request.getParameter("username") == null?"":request.getParameter("username").toString();
        String password = request.getParameter("password") == null?"":request.getParameter("password").toString();
        // 校验账号密码是否正确
        UserToken userToken = loginService.checkUser(username,password);
        if (userToken == null){
            return "false";
        }else {
            HttpSession session = request.getSession();
            session.setAttribute("userToken",userToken);
            session.setMaxInactiveInterval(7200);
//            session.setMaxInactiveInterval(Integer.parseInt(CommUtil.getResourceProperty("session-time").toString()));


            return "true";
        }

    }

    @RequestMapping("/getOpenId")
    public @ResponseBody Map<String, String> getOpenId(@RequestBody Map<String, String> param, HttpServletRequest request){
        String appId = "wx8f6af290103afafc";
        String secret = "6a22bdd32ca95eaadd7f234854885c87";
        // 生成3rd_session
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String session3rd = sdf.format(now);
        Map<String, String> resultMap = new HashMap<>();
        try {
            // 获取openID
            String result = HttpRequest.sendPost("https://api.weixin.qq.com/sns/jscode2session?appid="+appId+"&secret="+secret+"&js_code="+param.get("code")+"&grant_type=authorization_code",new HashMap<>());
            // 将3rd_session加上openid存入session中
            OpenId oi = JSON.parseObject(result, OpenId.class);
            HttpSession session = request.getSession();
            String sessionId = session.getId();
            resultMap.put("sessionId",sessionId);
            System.out.println(sessionId);
            session.setAttribute("openId", oi.getOpenid());
            session.setMaxInactiveInterval(300);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnrecoverableKeyException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return resultMap;
    }

    /**
     * @Description 检查注册情况
     * @author JerryWang
     * @date 2017/10/4 16:02
     * @param request
     * @return
     */
    @RequestMapping(value = "/checkRegister", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String checkRegister(HttpServletRequest request, HttpServletResponse response){
        String openId = request.getSession().getAttribute("openId").toString();
        Map<String, String> param = new HashMap<>();
        param.put("openId",openId);
        response.setContentType("text/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        return loginService.checkRegister(param);
    }

    @RequestMapping("/getUserId")
    public @ResponseBody String getUserId(HttpServletRequest request){
        String openId = request.getSession().getAttribute("openId").toString();
        return loginService.getUserId(openId);
    }
}
