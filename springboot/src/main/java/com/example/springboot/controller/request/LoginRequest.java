package com.example.springboot.controller.request;

/**
 * @BelongsProject: student-manager
 * @BelongsPackage: com.example.springboot.controller.request
 * @Author: yanhongwei
 * @CreateTime: 2023-07-01  11:37
 * @Description: TODO
 * @Version: 1.0
 */


public class LoginRequest {
    private String account;
    private String password;
    private String sno;

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
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
}
