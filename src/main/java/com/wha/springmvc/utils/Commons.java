package com.wha.springmvc.utils;

public class Commons {

	public static String generate(int length) {
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String pass = "";
		for (int x = 0; x < length; x++) {
			int i = (int) Math.floor(Math.random() * 26);
			pass += chars.charAt(i);
		}
		System.out.println(pass);
		return pass;
	}

	public static String generateNumber(int length) {
		String chars = "1234567890";
		String pass = "";
		for (int x = 0; x < length; x++) {
			int i = (int) Math.floor(Math.random() * 10);
			pass += chars.charAt(i);
		}
		System.out.println(pass);
		return pass;
	}
}
