package com.guru.test;

import com.google.gson.Gson;
import com.guru.entity.Courses;

public class Test {
	public static void main(String[] args) {
		Gson g = new Gson();
		
		Courses c = new Courses();
		c.setName("JAVA");
		c.setFee("2000.00");
		
		System.out.println(g.toJson(c));
	}
}
