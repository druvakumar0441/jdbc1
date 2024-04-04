package com.jdbc1;

public class employee {

	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getQual() {
		return qual;
	}
	public void setQual(String qual) {
		this.qual = qual;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	private String name;
	private int age;
	private String qual;
	private long mobile;
	@Override
	public String toString() {
		return "employee [id=" + id + ", name=" + name + ", age=" + age + ", qual=" + qual + ", mobile=" + mobile + "]";
	}
	public employee(String name, int age, String qual, long mobile) {
		super();
		this.name = name;
		this.age = age;
		this.qual = qual;
		this.mobile = mobile;
	}
	
}
