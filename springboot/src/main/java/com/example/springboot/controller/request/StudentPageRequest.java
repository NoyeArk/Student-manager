package com.example.springboot.controller.request;

/**
 * @BelongsProject: student-manager
 * @BelongsPackage: com.example.springboot.controller.request
 * @Author: yanhongwei
 * @CreateTime: 2023-06-29  17:39
 * @Description: TODO
 * @Version: 1.0
 */
public class StudentPageRequest extends BaseRequest{

    private String name;
    private String sno;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }
}
