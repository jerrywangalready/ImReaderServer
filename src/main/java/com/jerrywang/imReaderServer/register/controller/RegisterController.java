package com.jerrywang.imReaderServer.register.controller;

import com.jerrywang.imReaderServer.register.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author jerrywang
 * @create 2017/9/28.
 */
@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    RegisterService registerService;

    @RequestMapping("/doRegister")
    public @ResponseBody String doRegister(@RequestBody Map<String, String> param, HttpServletRequest request){
        String openId = request.getSession().getAttribute("openId").toString();
        param.put("openId",openId);
        return registerService.doRegister(param);
    }
}
