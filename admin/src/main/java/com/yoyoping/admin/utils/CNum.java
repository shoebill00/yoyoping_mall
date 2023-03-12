package com.yoyoping.admin.utils;

import java.math.BigDecimal;
import java.util.Random;
import java.util.regex.Pattern;

public class CNum {
    private static Random random = new Random(System.currentTimeMillis());

    private static final Pattern PATTERN = Pattern.compile("0|([-]?[1-9][0-9]*)");
    private static final String ESCAPES = "()[]*?+-.^$|\\";//特殊字符
    private static final Pattern PATTERN_NUM = Pattern.compile("[0-9]\\d*");

    //0或者1-9 可以-开头
    public static boolean isNum(String s) {
        if (s == null || s.equals("")) {
            return false;
        }
        if (!PATTERN.matcher(s).matches()) {
            return false;
        }
        return true;
    }

    //0-9之间的数字
    public static boolean isNumAll(String s){
        if (s == null || s.equals("")) {
            return false;
        }
        if (!PATTERN_NUM.matcher(s).matches()) {
            return false;
        }
        return true;
    }

    //正整数
    public static boolean isNumeric(String str) {
        for (int i = str.length(); --i >= 0; ) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    //是含有特殊字符
    public static boolean isEscapes(String str) {
        for (int j = 0; j < str.length(); j++) {
            char c = str.charAt(j);
            //把词条按照一个个字符追加到sb变量中
            if (ESCAPES.indexOf(c) != -1) {//包含
                return true;
            }
        }
        return false;
    }

    public static int intVal(int i) {
        return i;
    }

    //参数为null返回0，不为null返回参数的基本数据类型
    public static int intVal(Integer i) {
        if (i == null) {
            return 0;
        } else {
            return i.intValue();
        }
    }

    //把double值 以int类型返回值
    public static int intVal(double d) {
        return Double.valueOf(d).intValue();
    }

    //把数字字符串转成int类型返回
    public static int intVal(String s) {
        if (s == null || s.equals(""))
            return 0;
		/*char c;
		int i;
		for (i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			if ((c < '0' || c > '9') && c != '.')
				break;
		}
		if (i == 0)
			return 0;
		else {
			s = s.substring(0, i);
			return Double.valueOf(s).intValue();
		}*/
        int i = 0;
        try {
            i = Double.valueOf(s).intValue();
        } catch (Exception e) {
            i = 0;
        }
        return i;
    }

    //把数字类型参数 转成int
    public static int intVal(Object s) {
        int i = 0;
        try {
            i = Double.valueOf(s.toString()).intValue();
        } catch (Exception e) {
            i = 0;
        }
        return i;
    }

    public static int intVal(Long s) {
        int i = 0;
        try {
            if (s == null) {
                return 0;
            }
            i = s.intValue();
        } catch (Exception e) {
            i = 0;
        }
        return i;
    }

    public static long longVal(Object s) {
        long i = 0;
        try {
            i = Long.valueOf(s.toString()).longValue();
        } catch (Exception e) {
            i = 0;
        }
        return i;
    }

    public static long longVal(int i) {
        return i;
    }

    public static long longVal(Integer i) {
        if (i == null) {
            return 0;
        } else {
            return i.intValue();
        }
    }

    public static long longVal(long i) {
        return i;
    }

    public static long longVal(double d) {
        return Double.valueOf(d).longValue();
    }

    //字符串参数 转为 long类型返回
    public static long longVal(String s) {
        //如果参数为空值返回0
        if (s == null || s.equals(""))
            return 0;

        long i = 0;
        try {
            //转为long值
            i = Long.valueOf(s).longValue();
        } catch (Exception e) {
            i = 0;
        }
        return i;
    }

    public static double doubleVal(int i) {
        return i + 0.0;
    }

    public static double doubleVal(double d) {
        return d;
    }

    public static double doubleVal(String s) {
        if (s == null || s.equals(""))
            return 0.0;

        double v = 0;
        try {
            v = Double.valueOf(s).doubleValue();
        } catch (Exception e) {
            v = 0.0;
        }
        return v;
//		if (s == null || s.equals(""))
//			return 0.0;
//		char c;
//		int i;
//		for (i = 0; i < s.length(); i++) {
//			c = s.charAt(i);
//			if ((c < '0' || c > '9') && c != '.')
//				break;
//		}
//		if (i == 0)
//			return 0.0;
//		else {
//			s = s.substring(0, i);
//			return Double.valueOf(s).doubleValue();
//		}
    }
    /**包含开头和结束*/
    public static int getRandom(int start, int end) {
        int max = end - start + 1;
        int rnd = getRandom() % max;
        if (rnd < 0){
            rnd += max;
        }
        return rnd + start;
    }

    public synchronized static int getRandom() {
        return random.nextInt();
    }

    //转字符串
    public static String toString(int i) {
        return i + "";
    }

    public static String toString(double d) {
        return d + "";
    }

    public static double getDistance(double lon1, double lat1, double lon2, double lat2) {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lon1) - rad(lon2);
        double c = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
        c = c * 6378.137;
        // 6378.137赤道半径
        return Math.round(c * 10000d) / 10;
    }

    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }

    /**
     * 两数相除，四舍五入，保留2位小数，被除数要大于0
     *
     * @param n 除数
     * @param m 被除数
     * @return 返回浮点数
     */
    public static double reserveTwoBits(int n, int m) {
        if (m > 0) {
            return new BigDecimal((float) n / m).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        }
        return 0.0;
    }

    //保留2位小数，直接截断
    public static double twoPlace(double d) {
//        DecimalFormat df = new DecimalFormat("#.00");
//        String str = df.format(d);
        String dstr = Double.toString(d);
        if (dstr.length() > dstr.indexOf(".") + 2) {
            String substring = dstr.substring(0, dstr.indexOf(".") + 3);
            return Double.valueOf(substring);
        }
        return Double.valueOf(dstr);
    }

    //多数相加，不丢失精度，不舍入不截断，对精度要求高可用
    public static double accurateNum(String... nums) {
        BigDecimal bigDecimalSum = new BigDecimal("0.0");
        for (String num : nums) {
            BigDecimal bigDecimal = new BigDecimal(num);
            bigDecimalSum = bigDecimalSum.add(bigDecimal);
        }
        return bigDecimalSum.doubleValue();
    }


    /**
     * 抽奖概率
     *
     * @return int
     * @方法功能说明：
     * @创建： 2017年6月20日 By admin
     * @描述： TODO
     * @参数： @param choices
     * @参数： @return
     */
    public static int randomIndexWithValue(int[] choices) {
        int len = choices.length;
        if (len <= 0)
            return -1;
        int checkSum = 0;
        for (int i = 0; i < len; i++)
            checkSum += choices[i];

        int rand = intVal(Math.random() * checkSum);
        for (int i = 0; i < len; i++) {
            if (rand < choices[i])
                return i;
            else
                rand -= choices[i];
        }
        return -1;
    }



}
