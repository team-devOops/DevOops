package utils;

/**
 * 
 * @author zinzo
 * @date 2020.01.05
 */
public class StringUtils {
	/**
	 * @author zinzo
	 * @return String Empty 여부
	 */
	public static boolean isEmpty(String string) {
		if(string.equals("") || string == null) {
			return true;
		}

		return false;
	}
	
	/**
	 * @author zinzo
	 * @return String Not Empty 여부
	 */
	public static boolean isNotEmpty(String string) {
		if(string.equals("") || string == null) {
			return false;
		}

		return true;
	}
}
