package com.charles.util;

import java.io.IOException;

import net.sf.json.JSONObject;

import org.apache.http.ParseException;

import com.charles.customerservice.CustomerService;

public class CustomerServiceUtil extends CommonUtil{
	private static final String APPID = "wxfb198093aff4b211";//wx6bad3c216a01f1e3
	private static final String APPSECRET = "797c2c24157e417f7573726fde4001eb";//f9c931731d5b7ccd51644850a49a1b52
	private static final String CREATE_CustomerService_URL = "https://api.weixin.qq.com/customservice/kfaccount/add?access_token=ACCESS_TOKEN";
	
	public static CustomerService initCustomerService(){
		CustomerService customerService = new CustomerService();
		customerService.setKf_account("CharlesChan9502@gh_820d4de96d2e");
		customerService.setNickname("²âÊÔ¿Í·þ1");
		customerService.setPassword("e10adc3949ba59abbe56e057f20f883e");
		return customerService;
	}
	
	public static int createCustomerService(String token,String customerService) throws ParseException, IOException{
		int result = 0;
		String url = CREATE_CustomerService_URL.replace("ACCESS_TOKEN", token);
		JSONObject jsonObject = doPostStr(url, customerService);
		if(jsonObject != null){
			result = jsonObject.getInt("errcode");
		}
		return result;
	}
}
