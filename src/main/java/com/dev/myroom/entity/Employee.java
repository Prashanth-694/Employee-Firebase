package com.dev.myroom.entity;

import java.io.Serializable;

public class Employee implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
private String name;
private String des;
private int mobile;
public Employee(String id,String name, String des, int mobile) {
	super();
	this.id=id;
	this.name = name;
	this.des = des;
	this.mobile = mobile;
}
public Employee() {
	super();
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDes() {
	return des;
}
public void setDes(String des) {
	this.des = des;
}
public int getMobile() {
	return mobile;
}
public void setMobile(int mobile) {
	this.mobile = mobile;
}

}
