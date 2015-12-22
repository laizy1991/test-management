package constants.msg;

import utils.NumberUtil;

public enum MessageContentType {

	/**
	 * 普通文本
	 */
	TEXT(1),

	/**
	 * 语音
	 */
	AUDIO(2),

	/**
	 * 图片
	 */
	PICTURE(3),

	/**
	 * 富文本，默认类型，区分聊天消息的文本类型，后续可以新增类型
	 */
	RICH_TEXT(4),

	/**
	 * raw text message, contains content, no UID is associated
	 */
	TEXT_NOTIFICATION(5),

	/**
	 * 大表情
	 */
	FLAG_TYPE_EMOTION(6),
	
	/**
	 * 个人名片
	 */
	FLAG_TYPE_CONTACT_CARD(7),
	
	/**
	 * 通用类型卡片式显示的消息（如加群邀请、开黑提醒、开黑评价提醒等）
	 * 举例：ext_content = { _type: 3, room_id: 1234, title: '快来评价队友啦', avatar_url: 'http://黑店头像...', content: '黑店名称' }
	 * 其中 _type 的取值如下:
	 * 1 = 邀请加入聊天群
	 * 2 = 黑店相关提醒消息
	 * 3 = 黑店评价队友消息
	 * */
	FLAG_TYPE_GENERIC_CARD(8),
	/**
	 * 类似微信公众号消息（单条）
	 */
	FLAG_TYPE_COMPLEX_SINGLE(9),
	/**
	 * 类似微信公众号消息（2-5条，1条大的2-4条小的）
	 */
	FLAG_TYPE_COMPLEX_MULTIPLE(10),
	/**
	 * 抢订单
	 */
	FLAG_TYPE_QIANG_ORDER(11),
    /**
     * 退单
     */
    FLAG_TYPE_ORDER_REFUND(12);

	public static String getDesc( int type ){
		switch ( type ) {
		case 1:
			return "文字";
		case 2:
			return "语音";
		case 3:
			return "图片";
		case 4:
			return "富文本";
		case 5:
			return "文本提醒";
		case 6:
			return "大表情";
		case 7:
			return "个人名片";
		case 8:
			return "卡片式消息";
		case 9:
			return "单条公众号消息";
		case 10:
			return "多条公众号消息";
		case 11:
			return "抢订单消息";
		case 12:
			return "退单消息";

		default:
			break;
		}
		return "未知";
	}

	private Integer value;

	private MessageContentType(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return this.value;
	}
	
}
