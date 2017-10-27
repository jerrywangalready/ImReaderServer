package com.jerrywang.imReaderServer.login.model;

/**
 * @author jerrywang
 * @create 2017/9/24.
 */
public class OpenId {

    private String session_key;

    private int expires_in;

    private String openid;

    public String getSession_key() {
        return session_key;
    }

    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }

    public String getOpenid() {
        return openid;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }
}
