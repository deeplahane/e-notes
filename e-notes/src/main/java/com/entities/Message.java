package com.entities;

public class Message {
	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	private String content;
	private String cssClass;
	
	public Message(){
		super();
	}
	
	public Message(String content,String cssClass) {
		this.content=content;
		this.cssClass=cssClass;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content=content;
	}
	
	
	
}
