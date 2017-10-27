package com.jerrywang.imReaderServer.settings.controller;

import com.jerrywang.imReaderServer.settings.service.SettingsService;
import com.jerrywang.comm.util.service.CommService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jerrywang
 * @create 2017/8/24.
 */
@Controller
@RequestMapping("/settings")
public class SettingsController {

    @Autowired
    CommService commService;
    @Autowired
    SettingsService settingsService;

    @RequestMapping("/init")
    public String settingsInit(){
        return "/settings/settingsIndex";
    }

    @RequestMapping("/checkPassword")
    public @ResponseBody Map<String, Object> checkPassword(String password){
        Map<String, String> param = new HashMap<>();
        param.put("password", password);
        param.put("username", commService.getLoginInfo().getLoginUser());
        return settingsService.checkPassword(param);
    }

    @RequestMapping("/saveNewPassword")
    public @ResponseBody String saveNewPassword(@RequestBody Map<String, String> param){
        param.put("username", commService.getLoginInfo().getLoginUser());
        return settingsService.saveNewPassword(param);
    }
}
