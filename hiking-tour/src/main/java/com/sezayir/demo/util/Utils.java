package com.sezayir.demo.util;

public class Utils {

	public static boolean isValidDate(String date) {
		var regEx = "^\\d{4}-\\d{2}-\\d{2}$";
		return date.matches(regEx);
	}
}
