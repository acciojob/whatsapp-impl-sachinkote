package com.driver;

import java.util.Date;

public class Message {
    private int id;
    private String content;
    private Date timestamp;
	public Message() {
		super();
	}
	public Message(int id, String content) {
		super();
		this.id = id;
		this.content = content;
		this.timestamp =null;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

    
    
}
