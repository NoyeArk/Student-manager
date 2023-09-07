package com.example.springboot.entity;

import lombok.Data;

/**
 * @BelongsProject: student-manager
 * @BelongsPackage: com.example.springboot.entity
 * @Author: yanhongwei
 * @CreateTime: 2023-06-29  11:31
 * @Description: TODO
 * @Version: 1.0
 */

@Data
public class Admin {
    private String username;
    private String account;
    private String password;
    private String phone;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
