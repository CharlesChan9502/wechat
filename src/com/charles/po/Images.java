package com.charles.po;

public class Images extends BaseMessage {
	private String MsgType;
	private MediaId Image;
	private String CreateTime;
	
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
	public MediaId getImage() {
		return Image;
	}
	public void setImage(MediaId image) {
		Image = image;
	}
	public String getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}
}
