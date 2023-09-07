package com.example.springboot.controller.dto;

import lombok.Data;

/**
 * @BelongsProject: student-manager
 * @BelongsPackage: com.example.springboot.controller.dto
 * @Author: yanhongwei
 * @CreateTime: 2023-07-01  11:40
 * @Description: TODO
 * @Version: 1.0
 */
@Data
public class LoginDTO {
    private String username;
    private String account;
    private String phone;
}
