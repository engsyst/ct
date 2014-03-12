package com.engsyst.ct.entity;

import java.util.Random;

public class Rnd {
	private final static int MAX_COUNT = 30;
	private final static int MAX_LEN = 30;
	private final static char MAX_CHAR = 'z';
	private final static char MIN_CHAR = 'A';
	
	public static String getRandomString() {
		StringBuffer sb = new StringBuffer(MAX_LEN);
		Random r = new Random();
		for (int i = 0; i < r.nextInt(MAX_LEN-1)+1; i++) {
			char ch = (char) (r.nextInt(MAX_CHAR-MIN_CHAR) + MIN_CHAR);
			sb.append(ch);
		}
		return sb.toString();
	}
	public static int getRandomInt() {
		Random r = new Random();
		return r.nextInt(MAX_COUNT);
	}
}
