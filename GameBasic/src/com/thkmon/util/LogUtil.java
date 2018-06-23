package com.thkmon.util;

public class LogUtil {

	
	public static void debug(String str) {
		System.out.println(str);
	}
	
	
	public static void debug(Throwable throwable) {
		throwable.printStackTrace();
	}
}
