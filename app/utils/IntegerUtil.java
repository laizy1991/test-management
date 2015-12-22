package utils;

/**
 * 整型工具类型
 *
 */
public class IntegerUtil {

	/**
	 * 判断Integer对象是否为空或为0
	 * @param i
	 * @return
	 */
	public static boolean isNullOrZero(Integer i) {
		return (null == i) || (i.intValue() == 0);
	}
}
