package com.yoyoping.admin.utils;

import java.io.File;
import java.util.List;
import java.util.UUID;

public class CStr {

	//预防字符串空指针
	public static String noNull(String s) {
		//如果s为null返回空字符串；不为null则原样返回
		return s == null ? "" : s;
	}

	//预防任意对象空指针
	public static String noNull(Object s) {
		//如果s出异常，就显示空字符串
		String s1 = "";
		try {
			s1 = s.toString();
		} catch (Exception e) {
			s1 = "";
		}
		return s1;
	}

	//字符串空值判断
	public static boolean isEmpty(String s) {
		//如果s为null 或 长度为0  返回true
		return s == null || s.trim().length() == 0;
	}

	//字符串为null判断
	public static boolean isNull(String s) {
		return s == null;
	}

	//如果不是空值就取消前导和尾导空格
	public static String trim(String s) {
		if (s == null || s.length() == 0) {
			return s;
		} else {
			return s.trim();
		}
	}
	//如果参数为null 长度为0 返回""；否则去前导和尾导后返回
	public static String trimNoNull(String s) {
		if (s == null || s.length() == 0) {
			return "";
		} else {
			return s.trim();
		}
	}

	public static String toString(int i) {
		return String.valueOf(i);
	}

	public static String toString(double d) {
		return String.valueOf(d);
	}

	public static String toString(String d) {
		return d;
	}

	public static boolean isNick(String str) {
		if (str == null)
			return false;
		return str.matches("^[\\u4e00-\\u9fa5|\\w]+$");
	}

	public static boolean isEmail(String str) {
		if (str == null)
			return false;
		return str.matches("^[\\w\\.\\-]+@([\\w\\-]+\\.)+[\\w\\-]+$");
	}

	public static boolean isNumber(String str) {
		return str.matches("^[0-9\\.]+$");
	}

	public static boolean isInteger(String str) {
		if (str == null)
			return false;
		return str.matches("^\\d+$");
	}

	/**
	 * @param len
	 *            需要显示的长度(注意：长度是以byte为单位的，一个汉字是2个byte)
	 * @param symbol
	 *            用于表示省略的信息的字符，如“...”,“>>>”等。
	 * @return 返回处理后的字符串
	 */
	public static String byteCutLen(String str, int len, String symbol) {
		int c = 0;
		String s = null;
		if (symbol == null)
			symbol = "";
		try {
			byte[] b = str.getBytes("GBK");
			if (b.length <= len)
				return str;
			if (symbol.length() < b.length) {
				len = len - symbol.length();
			} else {
				symbol = "";
			}
			for (int i = 0; i < len; i++) {
				if (b[i] < 0)
					c++;
			}
			if (c % 2 == 0) {
				s = new String(b, 0, len, "GBK") + symbol;
			} else {
				s = new String(b, 0, len - 1, "GBK") + symbol;
			}
		} catch (Exception e) {
			s = str;
			e.printStackTrace();
		}
		return s == null ? "" : s;
	}

	public static String charCutLen(String str, int len, String symbol) {
		if (symbol == null)
			symbol = "";
		if (str == null) {
			return "";
		}
		if (str.length() <= len) {
			return str;
		}
		return str.substring(0, len) + symbol;

	}

	public static int getByteLen(String str) {
		if (str == null)
			return 0;
		int length = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) > 255) {
				length += 2;
			} else {
				length++;
			}
		}
		return length;
	}

	//获取随机的guid
	public static String getRandomGuid() {
		String guid = UUID.randomUUID().toString().toLowerCase();
		// 去掉-   包含开始索引，不包含结尾
		guid = guid.substring(0, 8) + guid.substring(9, 13)
				+ guid.substring(14, 18) + guid.substring(19, 23)
				+ guid.substring(24);
		return guid;
	}
	//把keyHead和所有key拼接后的 缓存key 返回 如：keyHead_key_key
	public static String getCacheKey(String keyHead, Object... key) {
		String re = keyHead;
		if (key != null && key.length > 0)
			// 可变参数取值要根据下标
			for (int i = 0; i < key.length; i++) {
				re += ("_" + key[i]);
			}
		return re;
	}

	//返回 keyHead + division + {key}
	public static String getDivisionKey(String division,String keyHead, Object... key) {
		String re = keyHead;
		if (key != null && key.length > 0)
			for (int i = 0; i < key.length; i++) {
				re += (division + key[i]);
			}
		return re;
	}

	public static String genRandomNum(int length) {
		String code = "";
		char c;
		double i;
		for (int j = 0; j < length; j++) {
			i = Math.random();
			c =  (char) (i * (57 - 48) + 48);
			code += c;
		}
		return code;
	}

	public static int optInt(String s,int opt){
		if (s == null || s.length() == 0) {
			return opt;
		}else {
			int i = 0;
			try {
				i = Double.valueOf(s).intValue();
			} catch (Exception e) {
				i = 0;
			}
			return i;
		}
	}

	//获取类资源路径  windows 和 linux都可以用
	public static String getClassResources(){
		String path =  (String.valueOf(Thread.currentThread().getContextClassLoader().getResource(""))).replaceAll("file:/", "").replaceAll("%20", " ").trim();
		if(path.indexOf(":") != 1) {
			//如果路径索引第二个字符位置不是“：”，就在路径前面加\
			path = File.separator + path;
		}
		return path;
	}

	public static String listIntegerToStr(List<Integer> integerList) {
		if (integerList == null) {
			return null;
		}
		StringBuilder result = new StringBuilder();
		boolean flag = false;
		for (Integer integer : integerList) {
			if (flag) {
				result.append(",");
			} else {
				flag = true;
			}
			result.append(integer);
		}
		return result.toString();
	}

	public static boolean isDefaultIMei(String str) {
		//定义正则
		String escapes = "0-";
		if (str == null) return true;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			/*不包含 说明有其他字符*/
			if (escapes.indexOf(c) < 0) {
				return false;
			}
		}
		return true;
	}

}
