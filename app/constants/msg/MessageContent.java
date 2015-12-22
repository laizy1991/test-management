package constants.msg;

public class MessageContent {
	public static String format( int contentType, String content ){
		if ( contentType == MessageContentType.PICTURE.getValue() ){
			return "<img src='"+content+"!big' />";
		}
		return content;
	}
}
