package com.example.springboot.service;

import com.example.springboot.controller.dto.LoginDTO;
import com.example.springboot.controller.request.BaseRequest;
import com.example.springboot.controller.request.LoginRequest;
import com.example.springboot.controller.request.StudentPageRequest;
import com.example.springboot.entity.Student;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IStudentService {

    List<Student> list();

    PageInfo<Student> page(BaseRequest baseRequest);

    void save(Student student);

    Student getBySno(String sno);

    void update(Student student);

    void deleteBySno(String sno);

    LoginDTO login(LoginRequest request);
}
