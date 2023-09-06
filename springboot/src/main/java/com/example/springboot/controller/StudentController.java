package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.controller.dto.LoginDTO;
import com.example.springboot.controller.request.LoginRequest;
import com.example.springboot.controller.request.StudentPageRequest;
import com.example.springboot.entity.Student;
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
@RequestMapping("/student")
public class StudentController {

    @Autowired
    IStudentService studentService;

    @PostMapping("/save")
    public Result save(@RequestBody Student student) {
        studentService.save(student);
        return Result.success();
    }

    @PostMapping("/login")
    public Result login(@RequestBody LoginRequest request) {
        LoginDTO login = studentService.login(request);
        return Result.success(login);
    }

    @PutMapping("/update")
    public Result update(@RequestBody Student student) {
        studentService.update(student);
        return Result.success();
    }

    @DeleteMapping("/delete/{sno}")
    public Result delete(@PathVariable String sno) {
        studentService.deleteBySno(sno);
        return Result.success();
    }

    @GetMapping("/{sno}")
    public Result getBySno(@PathVariable String sno) {
        Student student = studentService.getBySno(sno);
        return Result.success(student);
    }

    @GetMapping("/list")
    public Result list() {
        List<Student> students = studentService.list();
        return Result.success(students);
    }

    @GetMapping("/page")
    public Result page(StudentPageRequest studentPageRequest) {
        Object page = studentService.page(studentPageRequest);
        return Result.success(page);
    }

}




