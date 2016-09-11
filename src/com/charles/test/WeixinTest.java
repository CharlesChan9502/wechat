package com.charles.test;

import net.sf.json.JSONObject;

import com.charles.po.AccessToken;
import com.charles.util.WeiXinUtil;

public class WeixinTest {
	public static void main(String[] args) {
		try {
			AccessToken token = WeiXinUtil.getAccessToken();
			System.out.println("票据："+token.getToken());
			System.out.println("有效时间："+token.getExpiresIn());
			
			//String path = "D:/imooc.jpg";
			//String mediaId = WeixinUtil.upload(path, token.getToken(), "thumb");
			//System.out.println(mediaId);
			String menu = JSONObject.fromObject(WeiXinUtil.initMenu()).toString();
			int result = WeiXinUtil.createMenu(token.getToken(), menu);
			//String result = WeixinUtil.translateFull("");
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
