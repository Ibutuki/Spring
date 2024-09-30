package com.seiryo.action;

import java.io.IOException;
import java.io.PrintWriter;

import com.seiryo.entity.UserInfo;
import com.seiryo.util.BaseAction;

public class UserAction extends BaseAction<UserInfo> {
	private String captcha;
    private String msg;
	public String getCaptcha() {
		return captcha;
	}
	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String login() {
		String rand = (String) getSession().get("rand");
        if (captcha == null || !captcha.equals(rand)) {
            msg = "图片验证码错误";
            getRequest().put("msg", msg);
            return "login"; 
        }
		UserInfo user = getUserServiceImp().login(getModel());
		if(user == null){
			msg = "用户密码错误";
			return "login";
		}
		return "admin";
	}
}
