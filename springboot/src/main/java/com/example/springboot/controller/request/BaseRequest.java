package com.example.springboot.controller.request;

/**
 * @BelongsProject: student-manager
 * @BelongsPackage: com.example.springboot.controller.request
 * @Author: yanhongwei
 * @CreateTime: 2023-06-29  17:41
 * @Description: TODO
 * @Version: 1.0
 */
public class BaseRequest {
    private Integer pageNum = 1;
    private Integer pageSize = 10;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
