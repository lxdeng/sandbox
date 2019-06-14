package com.lxdeng.simplenote2.impl;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Note implements Serializable {

	private int id;
	private String content;
	
	public Note(String name) {
		this.content = name;
	}
	
	public Note(int id, String name) {
		this.id = id;
		this.content = name;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getContent() {
		return this.content;
	}
	
	public String toString() {
		return "id=" + id + ",name=" + content;
	}
}
