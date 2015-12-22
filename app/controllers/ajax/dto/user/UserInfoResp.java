package controllers.ajax.dto.user;

import constants.GlobalConstants;

public class UserInfoResp {


	/**
	 * 用户ID
	 */
	private int userId;
	
	private String yyId;
	
	/**
	 * 用户手机号码
	 */
	private String mobile;
	
	
	/**
	 * 是否删除
	 */
	private int isLock;
	
	/**
	 * 用户昵称
	 */
	private String nickName;
	
	/**
	 * 性别 
	 */
	private int sex;
	
	/**
	 * 生日
	 */
	private long birthday; 
	
	/**
	 * 创建时间
	 */
	private long createTime;
	
	/**
	 * LOGO图片ID
	 */
	private String pictureUrl;
	

	/**
	 * 年龄
	 */
	private int age;
	
	/**
	 * 用户所在省份
	 */
	private Integer province;
	
	/**
	 * 所在城市
	 */
	private Integer city;
	
	/**
	 * 修改时间
	 */
	private long modifyTime;

	/**
	 * 个性化签名
	 */
	private String signature;
	
	/**
	 * 好友权限设定
	 */
	private int friendPermission;

	/**
	 * 预号通知方式
	 */
	private int bookNotifyWay;
	
	/**
	 * 用户状态
	 */
	private int status;
	
	/**
     * 是否同意显示公会马甲（1、同意，其他：不同意）
     */
    private int isUseSockpuppet;

	/**
	 * 社交型的背景大图地址
	 */
	private String snsBackGroundImageUrl;

	public String getSnsBackGroundImageUrl() {
		return snsBackGroundImageUrl;
	}

	public void setSnsBackGroundImageUrl(String snsBackGroundImageUrl) {
		this.snsBackGroundImageUrl = snsBackGroundImageUrl;
	}

	private int level = 1;
	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getYyId() {
		return yyId;
	}

	public void setYyId(String yyId) {
		this.yyId = yyId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getBookNotifyWay() {
		return bookNotifyWay;
	}

	public void setBookNotifyWay(int bookNotifyWay) {
		this.bookNotifyWay = bookNotifyWay;
	}

	public int getFriendPermission() {
		return friendPermission;
	}

	public void setFriendPermission(int friendPermission) {
		this.friendPermission = friendPermission;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	} 
	public boolean isLock() {
		return isLock == GlobalConstants.TRUE;
	}
	
	public int getIsLock() {
		return isLock;
	}

	public void setIsLock(int isLock) {
		this.isLock = isLock;
	}

	/**
	 * 返回马甲昵称
	 * @return
	 */
	public String getNickName() {
		return this.nickName;
	}
	
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public long getBirthday() {
		return birthday;
	}

	public void setBirthday(long birthday) {
		this.birthday = birthday;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Integer getProvince() {
		return province;
	}

	public void setProvince(Integer province) {
		this.province = province;
	}

	public Integer getCity() {
		return city;
	}

	public void setCity(Integer city) {
		this.city = city;
	}

	public long getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(long modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

    public int getIsUseSockpuppet() {
        return isUseSockpuppet;
    }

    public void setIsUseSockpuppet(int isUseSockpuppet) {
        this.isUseSockpuppet = isUseSockpuppet;
    }
	

}
