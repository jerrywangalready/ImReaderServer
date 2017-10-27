package com.jerrywang.imReaderServer.chatBox.controller;

import com.alibaba.fastjson.JSON;
import com.jerrywang.comm.util.CommUtil;
import com.jerrywang.comm.util.HttpRequest;
import com.jerrywang.imReaderServer.chatBox.service.ChatBoxService;
import com.jerrywang.imReaderServer.login.model.OpenId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Context;
import java.io.*;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jerrywang
 * @create 2017/10/7.
 */
@Controller
@RequestMapping("/chatBox")
public class ChatBoxController {

    @Autowired
    ChatBoxService chatBoxService;


    @RequestMapping(value = "/uploadFile")
    public @ResponseBody String uploadFile(@RequestParam("file") MultipartFile file, String classCode, String cardDate, String soundsLength, HttpServletRequest request){
        try {
            String soundsName = CommUtil.getUUID();
            String path = CommUtil.getInstance().PROPERTIES.get("sounds-path");
            File uploadFile = new File(path + soundsName);
            file.transferTo(uploadFile);
            // 保存声音文件信息
            Map<String, Object> param = new HashMap<>();
            param.put("UUID",CommUtil.getUUID());
            param.put("CLASS_CODE",classCode);
            String openId = request.getSession().getAttribute("openId").toString();
            param.put("OPEN_ID",openId);
            param.put("SOUNDS_NAME",soundsName);
            DecimalFormat decimalFormat = new DecimalFormat("#0");
            int d = Integer.parseInt(soundsLength)/1000;
            param.put("SOUNDS_LENGTH",d);
            param.put("CARD_DATE",cardDate);
            chatBoxService.saveSoundsInfo(param);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "true";
    }

    @RequestMapping("downloadSounds")
    public void downloadSounds(HttpServletRequest request, HttpServletResponse response){
        String path = CommUtil.getInstance().PROPERTIES.get("sounds-path");
        String uuid = request.getParameter("uuid");
        try {
            // 获取原始文件名
            //String originName = workbenchService.getAttachmentNameByUuid(uuid);
            //String[] originNameArray = originName.split("\\.");
//            StringBuffer name = new StringBuffer();
//            String type = "";
//            if(originNameArray.length > 1) {
//                for (int i = 0; i < originNameArray.length - 1; i++) {
//                    name.append(originNameArray[i] + ".");
//                }
//                name.delete(name.length() - 1, name.length());
//                type = "."+originNameArray[originNameArray.length - 1];
//            }else {
//                name.append(originName);
//            }
            //设置响应头和客户端保存文件名
            response.setCharacterEncoding("utf-8");
            response.setContentType("multipart/form-data");
            response.setHeader("Content-Disposition", "attachment;fileName=" + new String("998".toString().getBytes("UTF-8"),"ISO8859-1") + ".silk");
            //打开本地文件流
            InputStream inputStream = new FileInputStream( path+"998");
            //激活下载操作
            OutputStream os = response.getOutputStream();

            //循环写入输出流
            byte[] b = new byte[2048];
            int length;
            while ((length = inputStream.read(b)) > 0) {
                os.write(b, 0, length);
            }

            // 这里主要关闭。
            os.close();
            inputStream.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
