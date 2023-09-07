package com.example.springboot.controller.request;

/**
 * @BelongsProject: student-manager
 * @BelongsPackage: com.example.springboot.controller.request
 * @Author: yanhongwei
 * @CreateTime: 2023-07-02  17:33
 * @Description: TODO
 * @Version: 1.0
 */
public class QueryRequest {
    private String account;
    private String sno;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }
}
