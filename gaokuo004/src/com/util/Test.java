package com.util;

import java.util.HashSet;
import java.util.Set;

import com.administrator.Administrator;

public class Test {

	public static void main(String[] args) {
		
		String str1 = "a";
		String str2 = "a";
		System.out.println(str1 == str2);
		String s1 = new String("a");
		String s2 = new String("a");
		System.out.println(s1 == s2);
		Administrator administrator1 = new Administrator("a","b");
		Administrator administrator2 = new Administrator("a","c");
		System.out.println(administrator1==administrator2);
		System.out.println(administrator1.equals(administrator2));
		Set<Administrator> i = new HashSet<>();
		i.add(administrator1);
		i.add(administrator2);
		System.out.println(i);
		System.out.println(administrator1.getUserName() == administrator2.getUserName());
	}

}
