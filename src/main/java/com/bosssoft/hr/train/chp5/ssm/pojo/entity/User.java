package com.bosssoft.hr.train.chp5.ssm.pojo.entity;

import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 用户类
 * @author likang
 */
@Table(name = "t_user")
public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 用户编号
     */
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long userId;
    /**
     * code
     */
    private String code;
    /**
     * 用户名
     */
    private String name;
    /**
     * 密码
     */
    private String password;
    /**
     * 性别
     */
    private String sex;
    /**
     * 生日
     */
    private Date birthday;
    /**
     * 职位编号
     */
    private Long positionId;
    /**
     * 电话
     */
    private String tel;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 其他联系
     */
    private String other;
    /**
     * 备注
     */
    private String remark;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Long getPositionId() {
        return positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", positionId=" + positionId +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", other='" + other + '\'' +
                ", remark='" + remark + '\'' +
                '}' + super.toString();
    }
}
