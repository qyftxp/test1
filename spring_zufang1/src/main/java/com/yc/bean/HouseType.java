package com.yc.bean;

import java.io.Serializable;

public class HouseType implements Serializable{
	private static final long serialVersionUID = 3256021506858668556L;
	private Integer id;
	private String name;
	
	
	public HouseType(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public HouseType() {
		super();
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "HouseType [id=" + id + ", name=" + name + "]";
	}
	
	
	
	
}
