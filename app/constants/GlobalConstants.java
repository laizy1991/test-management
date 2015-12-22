package constants;


public class GlobalConstants {

	public final static int DEFAULT_PAGE = 1;
	
	public final static int DEFAULT_PAGE_SIZE = 10;
	
	public final static int TWENTY_PAGE_SIZE = 20;
	
	/**
	 * 对应数据库中的判断字段
	 */
	public final static Integer FALSE = 0;
	
	/**
	 * 对应数据库中的判断字段
	 */
	public final static Integer TRUE = 1;
	
	/**
	 * 图片服务接口调用类型
	 */
	public final static Integer IMAGE_SERVER_API_TYPE = 6;
	
	/**
	 * 默认编码
	 */
	public final static String DEFAULT_CHARSET = "utf-8";
	
	/**
	 * 客服kk号
	 */
	public final static Integer CUSTOMER_SERVICE_USER_ID = 10002;
	
	/**
	 * 群logo压缩大小
	 */
	public final static String GROUP_LOGO_ZOOM = "300";
	
	/**
	 * 查询接口的最大值，超过这个值，服务器直接不进行处理
	 */
	public final static int MAX_LIMIT = 100;
	
	/**
	 * 公共号与普通用户的分隔线
	 */
	public final static int MAX_PUBLIC_ACCOUNT = 20000;
	
}
