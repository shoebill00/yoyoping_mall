package com.yoyoping.admin.model;

/**
 * @author zhangzheng on 12/3/2023
 */
public class AdminAccountDO {
    private int id;
    private String account;
    private String password;
    private String realName;
    private int phone;
    private String power;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "AdminAccountDO{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", realName='" + realName + '\'' +
                ", phone=" + phone +
                ", power='" + power + '\'' +
                '}';
    }
}
