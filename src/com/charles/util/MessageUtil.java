package com.charles.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.charles.po.News;
import com.charles.po.NewsMessage;
import com.charles.po.TextMessage;
import com.thoughtworks.xstream.XStream;


public class MessageUtil {
	
	public static final String MESSAGE_NEWS = "news" ;
	public static final String MESSAGE_TEXT = "text";
	public static final String MESSAGE_VOICE = "voice";
	public static final String MESSAGE_VIDEO = "video";
	public static final String MESSAGE_LOCATION = "location";
	public static final String MESSAGE_LINK = "link";
	public static final String MESSAGE_EVENT = "event";
	public static final String MESSAGE_SUBSCRIBE = "subscribe";
	public static final String MESSAGE_UNSUBSCRIBE = "unsubscribe";
	public static final String MESSAGE_CLICK = "CLICK";
	public static final String MESSAGE_VIEW = "VIEW";
	
	//xml转为Map集合
	public static Map<String, String> xmlToMap(HttpServletRequest request) throws IOException, DocumentException{
		Map<String, String> map = new HashMap<String, String>();
		SAXReader reader = new SAXReader();
		
		InputStream ins = request.getInputStream();
		Document doc = reader.read(ins);
		
		Element root = doc.getRootElement();
		
		@SuppressWarnings("unchecked")
		List<Element> list = root.elements();
		
		for(Element e:list){
			map.put(e.getName(), e.getText());
		}
		ins.close();
		return map;
	}
	
	//消息转为XML
	public static String textMessageToXml(TextMessage textMessage){
		XStream xstream = new XStream();
		xstream.alias("xml", textMessage.getClass());
		return xstream.toXML(textMessage);
	}
	
	//回复消息
	public static String initText(String toUserName,String fromUserName,String content){
		TextMessage text = new TextMessage();
		text.setFromUserName(toUserName);
		text.setToUserName(fromUserName);
		text.setMsgType(MessageUtil.MESSAGE_TEXT);
		text.setCreateTime(new Date().getTime()+"");
		text.setContent("后台返回信息是："+content);
		return textMessageToXml(text);
	}
	
	//图文消息
	public static String initNews(String toUserName,String fromUserName){
		NewsMessage news = new NewsMessage();
		news.setArticleCount("2");
		//news.setArticles(articles);
		news.setCreateTime(new Date().getTime()+"");
		news.setToUserName(fromUserName);
		news.setFromUserName(toUserName);
		news.setMsgType(MESSAGE_NEWS);
		
		
		List<News> newsList = new ArrayList<News>();
		for(int i=0;i<new Integer(news.getArticleCount());i++){
			News n = new News();
			n.setPicUrl("http://6b4010e6.ngrok.natapp.cn/wechat/images/abc.jpg");
			n.setTitle("测试标题");
			n.setDescription("测试描述");
			n.setUrl("www.baidu.com");
			newsList.add(n);
		}
		news.setArticles(newsList);
		return NewsMessageToXml(news);
	}
	
	public static String NewsMessageToXml(NewsMessage newsMessage){
		XStream xstream = new XStream();
		xstream.alias("xml", newsMessage.getClass());
		xstream.alias("item",new News().getClass());
		return xstream.toXML(newsMessage);
	}
	
	//主菜单
	public static String menuText(){
		StringBuffer sb = new StringBuffer();
		sb.append("欢迎你的关注，请按照菜单提示进行操作：\n\n");
		sb.append("1、课程介绍\n");
		sb.append("2、网站介绍\n\n");
		sb.append("回复？调出此菜单");
		return sb.toString();
	}

	public static String firstMenu(){
		StringBuffer sb = new StringBuffer();
		sb.append("介绍微信课程等等。test1");
		return sb.toString();
	}
	
	public static String secondMenu(){
		StringBuffer sb = new StringBuffer();
		sb.append("介绍微信网站等等。test2");
		return sb.toString();
	}
}
