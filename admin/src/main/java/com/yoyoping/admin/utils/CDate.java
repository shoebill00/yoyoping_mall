package com.yoyoping.admin.utils;



import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class CDate {
	private long ctime;
	private Date d;
	public static TimeZone TIME_ZONE_CHINA = TimeZone
			.getTimeZone("Asia/Shanghai");
	private static SimpleDateFormat format_utc =  new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
	public static String FORMAT_DATETIME = "yyyy-MM-dd HH:mm:ss";
	public static String FORMAT_DATE_TIME = "yyyy年MM月dd日  HH:mm";
	public static String FORMAT_DATE = "yyyy-MM-dd";
	public static String FORMAT_HOUR = "yyyy-MM-dd HH";
	public static String FORMAT_TIME = "HH:mm:ss";
	public static String FORMAT_UTC = "yyyy-MM-dd'T'HH:mm:ss'Z'";


	public CDate() {
		// ctime=System.currentTimeMillis();
		d = new Date();
		ctime = d.getTime();
	}

	public CDate(Date d) {
		ctime = d.getTime();
		this.d = d;
	}

	public CDate(int i) {
		ctime = (long) i * 1000;
		this.d = new Date(ctime);
	}

	public CDate(long l) {
		ctime = l;
		this.d = new Date(ctime);
	}

	public CDate(Integer i) {
		int j = CNum.intVal(i);
		ctime = (long) j * 1000;
		this.d = new Date(ctime);
	}

	public CDate(String date, String format) {
		DateFormat format1 = new SimpleDateFormat(format);
		format1.setTimeZone(TIME_ZONE_CHINA);
		// DateFormat df = DateFormat.getDateTimeInstance();
		try {
			this.d = format1.parse(date);
			ctime = d.getTime();
		} catch (Exception e) {

			e.printStackTrace();
			this.d = new Date(0);
			ctime = (long) 0;
		}
	}

	public CDate(String date) {
		DateFormat df = DateFormat.getDateTimeInstance();
		try {
			this.d = df.parse(date);
			ctime = d.getTime();
		} catch (Exception e) {

			e.printStackTrace();
			this.d = new Date(0);
			ctime = (long) 0;
		}
	}

	public void setTime(int c) {
		ctime = (long) c * 1000;
		this.d = new Date(ctime);
	}

	public void setTime(long c) {
		ctime = c;
		this.d = new Date(ctime);
	}

	public void setDate(Date d) {
		d = new Date();
		ctime = d.getTime();
	}

	/** output: a long int */
	public String getUnixTime() {
		return String.valueOf(Double.valueOf(this.ctime / 1000).intValue());
	}

	public int getUnixIntTime() {
		return (int) (this.ctime / 1000);
	}

	public long getUnixLongTime() {
		return this.ctime;
	}

	public Date getObject() {
		return this.d;
	}

	public String getDate() {
		/** output: 2006-4-16 */
		return DateFormat.getDateInstance(DateFormat.DEFAULT).format(d);
	}

	public String getFullDate() {
		/** output: 2006年4月16日 星期六 */
		DateFormat format1 = DateFormat
				.getDateInstance(DateFormat.FULL);
		format1.setTimeZone(TIME_ZONE_CHINA);
		return format1.format(d);
	}

	public String getMediumDate() {
		/** output: 2006-4-16 */
		DateFormat format1 = DateFormat
				.getDateInstance(DateFormat.MEDIUM);
		format1.setTimeZone(TIME_ZONE_CHINA);
		return format1.format(d);
	}

	public String getShortDate() {
		/** output: 06-4-16 */
		DateFormat format1 = DateFormat
				.getDateInstance(DateFormat.SHORT);
		format1.setTimeZone(TIME_ZONE_CHINA);
		return format1.format(d);
	}

	public String getLongTime() {
		/** output: 2006-01-01 00:00:00 */
		DateFormat format1 = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		format1.setTimeZone(TIME_ZONE_CHINA);
		return format1.format(d);
	}

	/** output: 01-01 00:00 */
	public String getShortTime() {
		DateFormat format1 = new SimpleDateFormat(
				"MM-dd HH:mm");
		format1.setTimeZone(TIME_ZONE_CHINA);
		return format1.format(d);
	}

	public String getTime() {
		/** output: 2006-01-01 00:00:00 */
		DateFormat format1 = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		format1.setTimeZone(TIME_ZONE_CHINA);
		return format1.format(d);
	}

	public String getTime(String ds) {
		try {
			DateFormat format1 = new SimpleDateFormat(ds);
			format1.setTimeZone(TIME_ZONE_CHINA);
			return format1.format(d);
		} catch (Exception e) {
			return "";
		}
	}

	public static String formatTime(Date date, String ds) {
		try {
			DateFormat format1 = new SimpleDateFormat(ds);
			format1.setTimeZone(TIME_ZONE_CHINA);
			return format1.format(date);
		} catch (Exception e) {
			return "";
		}
	}

	public static String formatTime(Timestamp time, String ds) {
		try {
			DateFormat format1 = new SimpleDateFormat(ds);
			format1.setTimeZone(TIME_ZONE_CHINA);
			return format1.format(time);
		} catch (Exception e) {
			return "";
		}
	}

	public static String formatTime(int unixTime, String ds) {
		try {
			DateFormat format1 = new SimpleDateFormat(ds);
			format1.setTimeZone(TIME_ZONE_CHINA);
			return format1.format(toDate(unixTime));
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * 判断日期为星期几,返回值为星期,如2则为星期二
	 *
	 * @return
	 */
	public int getChinaDayOfWeek() {
		// 首先定义一个calendar，必须使用getInstance()进行实例化
		Calendar aCalendar = Calendar.getInstance();
		// 里面野可以直接插入date类型
		aCalendar.setTime(d);
		// 计算此日期是一周中的哪一天
		int x = aCalendar.get(Calendar.DAY_OF_WEEK);
		// 标准周日是第一天，现在改过来,周一是第一天。
		x = x - 1;
		if (x == 0)
			x = 7;
		return x;
	}

	public int getChinaMondayUnixIntTime() {
		int t = getUnixIntTime();
		int w = getChinaDayOfWeek();
		t = t - (w - 1) * 24 * 3600;
		CDate md = new CDate(t);
		CDate md2 = new CDate(md.getTime("yyyy-MM-dd"), "yyyy-MM-dd");
		// System.out.println(md2.getLongTime());

		return md2.getUnixIntTime();
	}

	//获取当前时间戳到秒数
	public static int getCurrentUnixTime() {
		return new CDate().getUnixIntTime();
	}

	/*获取当前时间戳到毫秒*/
	public static long getCurrentUnixLongTime() {
		return new CDate().getUnixLongTime();
	}

	/** 获取当天0点的秒数 */
	public static int getCurrentStatUnixTime() {
		int now = new CDate().getUnixIntTime();
		return now - (now + 28800) % 86400;
	}

	/** 根据时间戳获取一年中的第几天 */
	public static int getDayOfYear(int nowIntTime) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date(nowIntTime*1000L));
		int i = calendar.get(Calendar.DAY_OF_YEAR);
		return i;
	}

	public static Date toDate(int unixTime) {
		long ctime = (long) unixTime * 1000;
		return new Date(ctime);
	}

	//时间戳转当前0点的时间戳
	public static int toStatUnixTime(int unixTime) {
		return unixTime - (unixTime + 28800) % 86400;
	}

	//时间转当前0点的时间戳
	public static int toStatUnixTime(Date date) {
		if (date == null) {
			return -28800;
		}
		int time = (int)(date.getTime() / 1000);
		return time - (time + 28800) % 86400;
	}

	public static int toUnixTime(Date date) {
		if (date == null) {
			return 0;
		}
		return (int)(date.getTime() / 1000);
	}

	//时间转毫秒的时间戳
	public static long toUnixLongTime(Date date) {
		if (date == null) {
			return 0;
		}
		return date.getTime();
	}

	@SuppressWarnings("deprecation")
	public int getDayCountOfMonth() {
		int days;
		switch (this.d.getMonth() + 1) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				days = 31;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				days = 30;
				break;
			case 2:
				days = isLeapYear() ? 29 : 28;
				break;
			default:
				days = 0;
				break;
		}
		return days;
	}

	// 判断闰年
	@SuppressWarnings("deprecation")
	public boolean isLeapYear() {
		int year = this.d.getYear();
		if (((year % 100 == 0) && year % 400 == 0)
				|| ((year % 100 != 0) && year % 4 == 0))
			return true;
		else
			return false;
	}

	//获取今天是一年当中的第几天
	public static int getToday(){
		return Calendar.getInstance().get(Calendar.DAY_OF_YEAR);
	}

	//获取年份
	public static int getYear(){
		return Calendar.getInstance().get(Calendar.YEAR);
	}

	public static int getYearByAdd(int day){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, day);
		return calendar.get(Calendar.YEAR);
	}

	public static int getDayOfYearByAdd(int day){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, day);
		return calendar.get(Calendar.DAY_OF_YEAR);
	}

	//获取今天是每年的第几周
	public static int getWeek(){
		Calendar calendar = Calendar.getInstance();
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		return calendar.get(Calendar.WEEK_OF_YEAR);
	}

	/**
	 * 获取某天是今年的第几周
	 * @param day 某天格式：2013-01-14
	 * @return
	 */
	public static int getWeek(String day){
		Calendar calendar = Calendar.getInstance();
		try {
			Date date = null;
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			date = format.parse(day);
			calendar.setFirstDayOfWeek(Calendar.MONDAY);
			calendar.setTime(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return calendar.get(Calendar.WEEK_OF_YEAR);
	}

	//获取月份
	public static int getMonth(){
		Calendar calendar = Calendar.getInstance();
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		return calendar.get(Calendar.MONTH);
	}

	//获取某天是今年的第几月
	public static int getMonth(String day){
		Calendar calendar = Calendar.getInstance();
		try {
			Date date = null;
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			date = format.parse(day);
			calendar.setFirstDayOfWeek(Calendar.MONDAY);
			calendar.setTime(date);
		}catch (ParseException e){
			e.printStackTrace();
		}
		return calendar.get(Calendar.MONTH);
	}

	//获取昨天的天数
	public static int getYesterday(){
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_YEAR, -1);
		return c.get(Calendar.DAY_OF_YEAR);
	}


	public static int getSevenDaysAgoDay(){
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_YEAR, -7);
		return c.get(Calendar.DAY_OF_YEAR);
	}


	public static Date parse(String str, String formatter) {
		if (CStr.isEmpty(str)) {
			return null;
		}
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat(formatter);
		try {
			date = sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}


	public  static long getTimestampByStr(String timeStr){
		Date downTimeDate = CDate.parse(timeStr, FORMAT_DATETIME);
		if(downTimeDate == null){
			return 0;
		}
		return downTimeDate.getTime();
	}
	/*
        传入字符串日期 根据其日期格式转成毫秒值
         */
	public static long getTimestampByStr(String timeStr,String formate){
		Date downTimeDate = CDate.parse(timeStr, formate);
		if(downTimeDate == null){
			return 0;
		}
		return downTimeDate.getTime();
	}

	//秒转日期 yyyy-MM-dd HH:mm:ss
	public static String stampToDate(int s){
		String res;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		res = simpleDateFormat.format(new Timestamp(1000L*s));
		return res;
	}

	//秒转日期 yyyy-MM-dd
	public static String stampToDateOther(int s){
		String res;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT_DATE);
		res = simpleDateFormat.format(new Timestamp(1000L*s));
		return res;
	}

	//日期 yyyy-MM-dd HH:mm:ss
	public static String getNowDate(){
		String res;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		res = simpleDateFormat.format(new Timestamp(new Date().getTime()));
		return res;
	}

	public static boolean largerTime(String t1,String t2)
	{
		Date date1 ,date2;
		DateFormat formart = new SimpleDateFormat("hh:mm");
		try
		{
			date1 = formart.parse(t1);
			date2 = formart.parse(t2);
			if(date1.compareTo(date2)<0)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		catch (ParseException e)
		{
			System.out.println("date init fail!");
			e.printStackTrace();
			return false;
		}

	}

	public static String getUTCStringDateByTimestamp(long timestamp) {
		// 1、取得本地时间：
		Calendar cal = Calendar.getInstance() ;
		// 2、取得时间偏移量：
		int zoneOffset = cal.get(Calendar.ZONE_OFFSET);
		// 3、取得夏令时差：
		int dstOffset = cal.get(Calendar.DST_OFFSET);
		// 4、从本地时间里扣除这些差量，即可以取得UTC时间：
		try{
			SimpleDateFormat utcformat =  new SimpleDateFormat(FORMAT_UTC);
			return utcformat.format(new Date(timestamp - (zoneOffset + dstOffset)));
		}catch(Exception e){
			e.printStackTrace() ;
		}
		return null;
	}

	//把参数格式化成  XX时XX分(不足一分钟不计算)
	public static Object timeFormat(Object videoTime){
		if (videoTime != null && !String.valueOf(videoTime).equals("0")) {
			if (CNum.intVal(videoTime) > 60 && CNum.intVal(videoTime) < 60 * 60) {
				//一小时以内，获取分=秒数/60
				int minutes = CNum.intVal(videoTime) / 60;
				videoTime = minutes + "分";
			} else if (CNum.intVal(videoTime) >= 60 * 60) {
				//大于一小时 获取小时=秒数/3600，获取剩余分=秒数/60
				int hours = CNum.intVal(videoTime) / 3600;
				int minutes = (CNum.intVal(videoTime) - (hours * 60 * 60)) / 60;
				videoTime = hours + "时" + minutes + "分";
			}else {
				videoTime = "0";
			}
		}
		return videoTime;
	}

	//把参数格式化成  XX时XX分XX秒,0就不展示
	public static Object timeFormatHMS(Object videoTime){
		StringBuffer sb = new StringBuffer();
		if (videoTime != null && !String.valueOf(videoTime).equals("0")) {
			if (CNum.intVal(videoTime) > 60 && CNum.intVal(videoTime) < 60 * 60) {
				//一小时以内，获取分=秒数/60
				int minutes = CNum.intVal(videoTime) / 60;
				int second = CNum.intVal(videoTime) - minutes * 60;
				sb.append(minutes).append("分");
				if(second > 0){
					sb.append(second).append("秒");
				}
				videoTime = sb.toString();
			} else if (CNum.intVal(videoTime) >= 60 * 60) {
				//大于一小时 获取小时=秒数/3600，获取剩余分=秒数/60
				int hours = CNum.intVal(videoTime) / 3600;
				int minutes = (CNum.intVal(videoTime) - (hours * 60 * 60)) / 60;
				int second = CNum.intVal(videoTime) - (hours * 60 * 60) - (minutes * 60);
				sb.append(hours).append("时");
				if(minutes > 0){
					sb.append(minutes).append("分");
					if (second > 0){
						sb.append(second).append("秒");
					}
				}else if (second > 0){
					sb.append(second).append("秒");
				}
				videoTime = sb.toString();
			}else {
				videoTime = videoTime + "秒";
			}
		}
		return videoTime;
	}

	//把参数格式化成  XX时XX分,（不足1分钟按1分钟计算）
	public static Object timeFormatHM(Object videoTime){
		StringBuffer sb = new StringBuffer();
		if (videoTime != null && !String.valueOf(videoTime).equals("0")) {
			if (CNum.intVal(videoTime) > 0 && CNum.intVal(videoTime) < 60 * 60) {
				//一小时以内，获取分=秒数/60
				int minutes = CNum.intVal(videoTime) / 60;
				int second = CNum.intVal(videoTime) - minutes * 60;
				if(second > 0){
					minutes += 1;
				}
				sb.append(minutes).append("分");
				videoTime = sb.toString();
			} else if (CNum.intVal(videoTime) >= 60 * 60) {
				//大于一小时 获取小时=秒数/3600，获取剩余分=秒数/60
				int hours = CNum.intVal(videoTime) / 3600;
				int minutes = (CNum.intVal(videoTime) - (hours * 60 * 60)) / 60;
				int second = CNum.intVal(videoTime) - (hours * 60 * 60) - (minutes * 60);
				if(second > 0){
					minutes += 1;
				}
				sb.append(hours).append("时");
				if(minutes > 0){
					sb.append(minutes).append("分");
				}
				videoTime = sb.toString();
			}else {
				videoTime = "数据异常";
			}
		}
		return videoTime;
	}

	/**获取UTC格式时间 day为与今日相差几天。>0 为增加，<0为减少
	 */
	public static String getUTCStringDate(int day) {
		// 1、取得本地时间：
		Calendar cal = Calendar.getInstance() ;
		cal.add(Calendar.DAY_OF_YEAR, day);
		// 2、取得时间偏移量：
		int zoneOffset = cal.get(Calendar.ZONE_OFFSET);
		// 3、取得夏令时差：
		int dstOffset = cal.get(Calendar.DST_OFFSET);
		// 4、从本地时间里扣除这些差量，即可以取得UTC时间：
		cal.add(Calendar.MILLISECOND, -(zoneOffset + dstOffset));
		try{
			return format_utc.format(cal.getTime());
		}catch(Exception e){
			e.printStackTrace() ;
		}
		return null ;
	}


	/**获取UTC格式时间 hour为与当前时间相差几小时。>0 为增加，<0为减少
	 */
	public static String getUTCStringDateByHour(int hour) {
		// 1、取得本地时间：
		Calendar cal = Calendar.getInstance() ;
		cal.add(Calendar.HOUR_OF_DAY, hour);
		// 2、取得时间偏移量：
		int zoneOffset = cal.get(Calendar.ZONE_OFFSET);
		// 3、取得夏令时差：
		int dstOffset = cal.get(Calendar.DST_OFFSET);
		// 4、从本地时间里扣除这些差量，即可以取得UTC时间：
		cal.add(Calendar.MILLISECOND, -(zoneOffset + dstOffset));
		try{
			return format_utc.format(cal.getTime());
		}catch(Exception e){
			e.printStackTrace() ;
		}
		return null ;
	}

	/**
	 * @return Date
	 * @方法功能说明：
	 * @创建： 2017年3月21日 By mrx
	 * @描述： TODO 返回相差？日
	 * @参数： @param start  end
	 * @参数： @return
	 */
	public static long getDiffDay(Date start, Date end) {
		long date = start.getTime() - end.getTime();
		long day = date / (1000 * 60 * 60 * 24);
		return day;
	}

	/**
	 * @return Date
	 * @方法功能说明：
	 * @创建： 2017年3月21日 By mrx
	 * @描述： TODO 返回相差？日
	 * @参数： @param start  end
	 * @参数： @return
	 */
	public static long getDiffDay(long start, long end) {
		long date = start-end;
		long day = date / (1000 * 60 * 60 * 24);
		return day;
	}

	/**
	 * @return Date
	 * @方法功能说明：
	 * @创建： 2017年3月21日 By mrx
	 * @描述： TODO 返回相差？日
	 * @参数： @param start  end
	 * @参数： @return
	 */
	public static long getUnixDiffDay(long start, long end) {
		long date = start-end;
		long day = date / ( 60 * 60 * 24);
		return day;
	}

	public static String getAmazonExpiresDate(long expires){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		Date date = new Date(expires);
		String formatStr = sdf.format(date);
		return formatStr;
	}

	/**参数毫秒值转为yyyy-MM-dd*/
	public static String millisecondChangeDateStr(long millisecond){
		if(millisecond <=0 ){
			return "毫秒值转日期异常";
		}
		Date date = new Date(millisecond);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dayStr = sdf.format(date);
		return dayStr;
	}

}
