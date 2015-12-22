package constants;

public enum GlobalPrivilege {
	//重要！枚举值不能随意修改  按规范制定，只是服务端内部权限使用，不开放给外部
	
	NO_GUILD_USER(0L, "未入会成员"),
	GUILD_COMMON_USER(1L << 0, "公会普通成员"),
	GUILD_ADMIN(1L << 1, "公会管理员"),
	PRESIDENT((1L << 2) | GUILD_ADMIN.getPrivilegeFlag(), "会长"),
	GROUP_COMMON_USER(1L << 3, "群普通成员"),
	GROUP_ADMIN(1L << 4, "群管理员"),
	GROUP_OWNER((1L << 5) | GROUP_ADMIN.getPrivilegeFlag(), "群主"),
	BAR_ADMIN(1L << 6, "吧管理员"),
	BAR_OWNER((1L << 7) | BAR_ADMIN.getPrivilegeFlag(), "吧主"),
	BAR_TOPIC_SPONSOR(1L << 8, "话题发起人"),
	SUPER_ADMIN(Long.MAX_VALUE, "超级管理员");
	
	/**
	 * 提供给客户端用的唯一标识，以64位长整型二进制位数表示，
	 * 如整型位数00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000  表示 未入会成员角色
	 * 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000001  表示 公会普通成员
	 * 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00001000  表示 群普通成员
	 * 同时具备两种以上权限使用 ‘|’ 符合进行与操作
	 * 
	 */
	private Long flag;
	
	private String desc;
	
	private GlobalPrivilege(Long privilegeFlag, String desc) {
		this.flag = privilegeFlag;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public Long getPrivilegeFlag() {
		return flag;
	}
	
	public static boolean hasPrivilege(long privilegeFlag, GlobalPrivilege privilege) {
        return (privilegeFlag & privilege.getPrivilegeFlag()) > 0;
    }
	
}
