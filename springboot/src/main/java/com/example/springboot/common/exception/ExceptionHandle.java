package com.example.springboot.common.exception;

import com.example.springboot.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @BelongsProject: student-manager
 * @BelongsPackage: com.example.springboot.common.exception
 * @Author: yanhongwei
 * @CreateTime: 2023-07-01  15:19
 * @Description: TODO
 * @Version: 1.0
 */

@Slf4j
@RestControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = ServiceException.class)
    public Result serviceExceptionError(Exception e) {
        log.error("业务错误", e);
        return Result.error(e.getMessage());
    }
}
