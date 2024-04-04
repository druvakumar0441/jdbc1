package com.jdbc1;

public class One {

	static {
		System.out.println("one static");
	}
	{
		System.out.println("normal block");
	}
	public static void main(String[] args) {
		One o  = new One();
	}
}
