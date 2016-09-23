package com.charles.wechat4j.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.charles.wechat4j.support.Lejian;

public class WeChatServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Lejian lejian = new Lejian(request);

		String result = lejian.execute();

		response.getOutputStream().write(result.getBytes());

		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Lejian lejian = new Lejian(request);

		String result = lejian.execute();

		response.getOutputStream().write(result.getBytes());

		 

		}
}
