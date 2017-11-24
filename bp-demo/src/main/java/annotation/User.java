package annotation;

import java.util.Date;

/**
 * Created by Administrator on 2017-11-24.
 */
@Entity
//@Table
@Table("user_tb")
public class User {

    @Column
    private String name;

    @Column
    private String pwd;

    @Column
    private Short age;

    @Column
    private Date createDate;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    public User(String name, String pwd, Short age) {
        this.name = name;
        this.pwd = pwd;
        this.age = age;
    }

    public User() {
    }
}
