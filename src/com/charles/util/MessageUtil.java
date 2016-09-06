package com.charles.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.charles.po.ImageMessage;
import com.charles.po.TextMessage;
import com.thoughtworks.xstream.XStream;


public class MessageUtil {
	
	public static final String MESSAGE_IMAGE = "image" ;
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
	
	//xmlתΪMap����
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
	
	//��ϢתΪXML
	public static String textMessageToXml(TextMessage textMessage){
		XStream xstream = new XStream();
		xstream.alias("xml", textMessage.getClass());
		return xstream.toXML(textMessage);
	}
	
	//�ظ���Ϣ
	public static String initText(String toUserName,String fromUserName,String content){
		TextMessage text = new TextMessage();
		text.setFromUserName(toUserName);
		text.setToUserName(fromUserName);
		text.setMsgType(MessageUtil.MESSAGE_TEXT);
		text.setCreateTime(new Date().getTime()+"");
		text.setContent("��̨������Ϣ�ǣ�"+content);
		return textMessageToXml(text);
	}
	
	//�ظ�ͼƬ
	public static String initImage(String toUserName,String fromUserName){
		ImageMessage image = new ImageMessage();
		image.setFromUserName(toUserName);
		image.setToUserName(fromUserName);
		image.setMsgType(MESSAGE_IMAGE);
		image.setCreateTime(new Date().getTime()+"");
		image.setMediaId("test");
		image.setPicUrl("http://6b4010e6.ngrok.natapp.cn/wechat/images/1.jpg");
		return imageMessageToXml(image);
	}
	
	//ͼƬת��Ϊxml
	public static String imageMessageToXml(ImageMessage imageMessage){
		XStream xstream = new XStream();
		xstream.alias("xml", imageMessage.getClass());
		return xstream.toXML(imageMessage);
	}
	
	//���˵�
	public static String menuText(){
		StringBuffer sb = new StringBuffer();
		sb.append("��ӭ��Ĺ�ע���밴�ղ˵���ʾ���в�����\n\n");
		sb.append("1���γ̽���\n");
		sb.append("2����վ����\n\n");
		sb.append("�ظ��������˲˵�");
		return sb.toString();
	}

	public static String firstMenu(){
		StringBuffer sb = new StringBuffer();
		sb.append("����΢�ſγ̵ȵȡ�test1");
		return sb.toString();
	}
	
	public static String secondMenu(){
		StringBuffer sb = new StringBuffer();
		sb.append("����΢����վ�ȵȡ�test2");
		return sb.toString();
	}
}
