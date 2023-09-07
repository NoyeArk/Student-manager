package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.controller.dto.LoginDTO;
import com.example.springboot.controller.request.AdminPageRequest;
import com.example.springboot.controller.request.LoginRequest;
import com.example.springboot.controller.request.StudentPageRequest;
import com.example.springboot.entity.Admin;
import com.example.springboot.entity.Student;
import com.example.springboot.service.IAdminService;
import com.example.springboot.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @BelongsProject: student-manager
 * @BelongsPackage: com.example.springboot.controller
 * @Author: yanhongwei
 * @CreateTime: 2023-06-29  16:29
 * @Description: TODO
 * @Version: 1.0
 */

//表明该类是....接口，json格式返回
@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    IAdminService adminService;

    @PostMapping("/login")
    public Result login(@RequestBody LoginRequest request) {
        LoginDTO login = adminService.login(request);
        return Result.success(login);
    }

    @PostMapping("/save")
    public Result save(@RequestBody Admin admin) {
        adminService.save(admin);
        return Result.success();
    }

    @PutMapping("/update")
    public Result update(@RequestBody Admin admin) {
        adminService.update(admin);
        return Result.success();
    }

    @PostMapping("/reset")
    public Result resetPassword(@PathVariable String account) {
        adminService.resetPassword(account);
        return Result.success();
    }

    @DeleteMapping("/delete/{account}")
    public Result delete(@PathVariable String account) {
        adminService.deleteByAccount(account);
        return Result.success();
    }

    @CrossOrigin
    @GetMapping("/getInfo/{account}")
    public Result getByAccount(@PathVariable String account) {
        Admin admin = adminService.getByAccount(account);
        return Result.success(admin);
    }

    @GetMapping("/list")
    public Result list() {
        List<Admin> admins = adminService.list();
        return Result.success(admins);
    }

    @GetMapping("/page")
    public Result page(AdminPageRequest adminPageRequest) {
        Object page = adminService.page(adminPageRequest);
        return Result.success(page);
    }
}




