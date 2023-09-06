package com.example.springboot.mapper;

import com.example.springboot.controller.request.BaseRequest;
import com.example.springboot.controller.request.LoginRequest;
import com.example.springboot.controller.request.StudentPageRequest;
import com.example.springboot.entity.Admin;
import com.example.springboot.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface StudentMapper {

//    @Select("select * from student")
    List<Student> list();

    List<Student> listByCondition(BaseRequest baseRequest);

    void save(Student student);

    Student getBySno(String sno);

    void updateBySno(Student student);

    void deleteBySno(String sno);

    Student getBySnoAndPassword(LoginRequest request);
}
