package com.example.springboot.common;

import lombok.Data;

/**
 * @BelongsProject: student-manager
 * @BelongsPackage: com.example.springboot.common
 * @Author: yanhongwei
 * @CreateTime: 2023-06-29  17:25
 * @Description: TODO
 * @Version: 1.0
 */

@Data
public class Result {
    private static final String SUCCESS_CODE = "1";
    private static final String ERROR_CODE = "-1";

    private String code;
    private Object data;
    //存放错误信息
    private String msg;

    public static Result success() {
        Result result = new Result();
        result.setCode(SUCCESS_CODE);
        return result;
    }

    public static Result success(Object data) {
        Result result = new Result();
        result.setCode(SUCCESS_CODE);
        result.setData(data);
        return result;
    }

    public static Result error() {
        Result result = new Result();
        result.setCode(ERROR_CODE);
        return result;
    }

    public static Result error(Object data) {
        Result result = new Result();
        result.setCode(ERROR_CODE);
        result.setData(data);
        return result;
    }
}
