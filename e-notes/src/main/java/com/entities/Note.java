package com.entities;

public class Note {
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPdate() {
		return pdate;
	}
	public void setPdate(String pdate) {
		this.pdate = pdate;
	}
	public int getUserid() {
		return Userid;
	}
	public void setUserid(int userid) {
		Userid = userid;
	}
	private int id;
	private String title;
	private String content;
	private String pdate;
	private int Userid;
	public Note() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Note(int id, String title, String content, String pdate, int userid) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.pdate = pdate;
		Userid = userid;
	}
	public Note(String title, String content, String pdate, int userid) {
		super();
		this.title = title;
		this.content = content;
		this.pdate = pdate;
		Userid = userid;
	}
	
	
}
