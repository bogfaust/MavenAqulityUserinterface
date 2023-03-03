package tests.utils;

import java.util.*;

public class StringUtil {
	private static final String bothSymbol = StringUtil.getRandomString(1, 1, "UpperLatin");

	public static String getPassword() {
		return bothSymbol +
				StringUtil.getRandomString(1, 1, "Digits") +
				StringUtil.getRandomString(1, 1, "LowerCyrillic") +
				StringUtil.getRandomString(10, 10, "LowerLatin");
	}

	public static String getEmail() {
		return bothSymbol +
				StringUtil.getRandomString(8, 8, "LowerLatin");
	}

	public static String getDomain() {
		return StringUtil.getRandomString(8, 8, "LowerLatin");
	}

	public static String getRandomString(int minCount, int maxCount, String type) {

		String chars = "";
		switch (type) {
			case "UpperLatin":
				chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
				break;

			case "LowerLatin":
				chars = "abcdefghijklmnopqrstuvwxyz";
				break;

			case "Digits":
				chars = "1234567890";
				break;

			case "LowerCyrillic":
				chars = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
				break;

			default:
				return "__unknown__";
		}

		StringBuilder str = new StringBuilder();
		Random rnd = new Random();
		while (str.length() < rnd.nextInt(maxCount - minCount + 1) + minCount) {
			int index = (int) (rnd.nextFloat() * chars.length());
			str.append(chars.charAt(index));
		}
		return str.toString();
	}
}
