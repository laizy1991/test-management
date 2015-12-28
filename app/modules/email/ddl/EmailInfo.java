package modules.email.ddl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import play.db.jpa.Model;

@Entity
@Table(name = "email_info")
public class EmailInfo extends Model{
    //columnDefinition: 表示该字段在数据库中的实际类型 . 通常 ORM 框架可以根据属性类型自动判断数据库中字段的类型 , 但是对于 Date 类型仍无法确定数据库中字段类型究竟是 DATE,TIME 还是 TIMESTAMP. 此外 ,String 的默认映射类型为 VARCHAR, 如果要将 String 类型映射到特定数据库的 BLOB 或 TEXT 字段类型 , 该属性非常有用 .

    private String name;
    private String address;
    @Column(name="department_id")
    private Integer departmentId;
    @Column(name="create_time")
    private Long createTime;
    @Column(name="update_time")
    private Long updateTime;
    
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
