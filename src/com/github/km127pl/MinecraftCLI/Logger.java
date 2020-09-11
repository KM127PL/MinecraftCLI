package com.github.km127pl.MinecraftCLI;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
	
	public static String returnTime() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		return "[" + dtf.format(now) + "] ";
	}
	
	public static void log(String txt) {
		String msg = returnTime() + txt;
		System.out.println(msg);
	}
	
	public static String censore(String txt) {
		String[] censoredText = new String[txt.length()];
		for(int i = 0; i < txt.length(); i++) {
			censoredText[i] = "*";
		}
		return censoredText.toString();
	}
}
