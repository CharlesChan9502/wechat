package com.charles.customerservice;

import java.io.IOException;

import org.apache.http.ParseException;

import net.sf.json.JSONObject;

import com.charles.po.AccessToken;
import com.charles.util.CustomerServiceUtil;
import com.charles.util.WeiXinUtil;

public class CStest {
	public static void main(String[] args) throws ParseException, IOException {
		AccessToken token = WeiXinUtil.getAccessToken();
		String cs = JSONObject.fromObject(CustomerServiceUtil.initCustomerService()).toString();
		int result = CustomerServiceUtil.createCustomerService(token.getToken(), cs);
		System.out.println(result);
	}
}
