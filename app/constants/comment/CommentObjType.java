package constants.comment;


public enum CommentObjType {

	TOPIC(0);
	
	private Integer value;
	
	private CommentObjType(Integer value) {
		this.value = value;
	}
	
	public Integer getValue() {
    	return value;
    }

	public static CommentObjType getCommentObjType(Integer type) {
		if(type == null) {
			return null;
		}
        for (CommentObjType objType : CommentObjType.values()) {
            if (objType.getValue().equals(type)) {
                return objType;
            }
        }
        return null;
    }
}
