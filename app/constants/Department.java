package constants;

public enum Department {
    TEST(0, "测试"),
    DEV(1, "开发"),
    OTHER(2, "其他");
    
    private String desc;
    private Integer code;
    
    private Department(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static String getgDescByCode(Integer code) {
        if(code == null) {
            return "";
        }
        
        for(Department depart : Department.values()) {
            if(depart != null && depart.getCode().intValue() == code.intValue()) {
                return depart.getDesc();
            }
        }
        
        return "";
    }
    
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
