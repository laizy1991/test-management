package controllers.dto;

import modules.email.ddl.EmailInfo;
import constants.Department;


public class EmailInfoDto {
    private Integer id;
    private String name;
    private String address;
    private Integer departmentId;
    private String department;
    private Long createTime;
    private Long updateTime;
    public EmailInfoDto() {
        
    }
    
    public EmailInfoDto(EmailInfo info) {
        if(info == null) {
            return;
        }
        this.address = info.getAddress();
        this.createTime = info.getCreateTime();
        this.department = Department.getgDescByCode(info.getDepartmentId());
        this.departmentId = info.getDepartmentId();
        this.id = info.getId().intValue();
        this.name = info.getName();
        this.updateTime = info.getUpdateTime();
    }
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Integer getDepartmentId() {
        return departmentId;
    }
    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public Long getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
    public Long getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
}
