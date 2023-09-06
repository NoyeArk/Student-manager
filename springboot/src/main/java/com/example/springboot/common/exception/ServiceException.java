package com.example.springboot.common.exception;

/**
 * @BelongsProject: student-manager
 * @BelongsPackage: com.example.springboot.common.exception
 * @Author: yanhongwei
 * @CreateTime: 2023-07-01  16:53
 * @Description: TODO
 * @Version: 1.0
 */

public class ServiceException extends RuntimeException{

    public ServiceException(String message) {
        super(message);
    }
}
