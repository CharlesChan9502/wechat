package com.charles.util;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import org.apache.http.ParseException;

import com.charles.po.AccessToken;

import net.sf.json.JSONObject;

public class testUrl {
	 /**     
     * ��������main</br>
     * ����������URL���� </br>
     * ������Ա��souvc </br>
     * ����ʱ�䣺2016-1-4  </br>
     * @param args ˵������ֵ����
	 * @throws IOException 
	 * @throws ParseException 
	 * @throws NoSuchProviderException 
	 * @throws NoSuchAlgorithmException 
	 * @throws KeyManagementException 
     * @throws ˵���������쳣������
     */
    public static void main(String[] args) throws ParseException, IOException, KeyManagementException, NoSuchAlgorithmException, NoSuchProviderException {
    	/*AccessToken accessToken = WeiXinUtil.getAccessToken();
    	String source="http://http://3f559527.ngrok.natapp.cn/wechat/oauthServlet";
        System.out.println(UserUtil.urlEncodeUTF8(source));*/
    	AccessToken accessToken = WeiXinUtil.getAccessToken();
    	String path = "C:/Users/Administrator/Desktop/22.jpg";
    	String mediaId = WeiXinUtil.upload(path, accessToken.getToken(), "image");
    	/*AccessToken accessToken = WeiXinUtil.getAccessToken();
    	String menu = JSONObject.fromObject(WeiXinUtil.initMenu()).toString();
    	int result = WeiXinUtil.createMenu(accessToken.getToken(), menu);
    	if(result==0){
    		System.out.println("success");
    	}else{
    		System.out.println("errcode:"+result);
    	}*/
    }

}
