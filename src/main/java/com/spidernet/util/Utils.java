package com.spidernet.util;

import java.util.UUID;

public class Utils {
	public static String getUUID() {
		String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
		return uuid;
	}
}
