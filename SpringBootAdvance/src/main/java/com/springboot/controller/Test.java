package com.springboot.controller;

import java.util.Arrays;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		List<String> strList = Arrays.asList("xyz","pqr","lm11111n","abc","pqr","ghddf","xyz","pdf","lmn","pdf","ghf");

		System.out.println(strList.parallelStream()
			   .reduce("",(str1,str2) -> str1.length()>str2.length()?str1:str2));
	}

}
