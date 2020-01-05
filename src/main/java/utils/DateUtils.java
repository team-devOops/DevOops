package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author zinzo
 * @date 2020.01.05
 */
public class DateUtils {
	/**
	 * @author zinzo
	 * @return yyyy.MM.dd 형식의 오늘 날짜
	 */
	public static Date getToday() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
		
		String strDate = dateFormat.format(new Date());
		
		Date today = null;
		try {
			today = dateFormat.parse(strDate);
		} 
		catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return today;
	}
	
	/**
	 * @author zinzo
	 * @param datePattern
	 * @return 입력된 형식의 오늘 날짜
	 */
	public static Date getToday(String datePattern) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern);
		
		String strDate = dateFormat.format(new Date());
		
		Date today = null;
		
		try {
			today = dateFormat.parse(strDate);
		} 
		catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return today;
	}
	
	/**
	 * @author zinzo
	 * @return yyyy.MM.dd HH:mm:ss
	 */
	public static Date getTimeStamp() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		
		String strDate = dateFormat.format(new Date());
		
		Date today = null;
		
		try {
			today = dateFormat.parse(strDate);
		} 
		catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return today;
	}
}
