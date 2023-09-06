package com.example.springboot.service.impl;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.example.springboot.common.exception.ServiceException;
import com.example.springboot.controller.dto.LoginDTO;
import com.example.springboot.controller.request.BaseRequest;
import com.example.springboot.controller.request.LoginRequest;
import com.example.springboot.controller.request.StudentPageRequest;
import com.example.springboot.entity.Admin;
import com.example.springboot.entity.Student;
import com.example.springboot.mapper.StudentMapper;
import com.example.springboot.service.IStudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Date;
import java.util.List;

/**
 * @BelongsProject: student-manager
 * @BelongsPackage: com.example.springboot.service.impl
 * @Author: yanhongwei
 * @CreateTime: 2023-06-29  11:38
 * @Description: TODO
 * @Version: 1.0
 */

@CrossOrigin
@Service
public class StudentService implements IStudentService {

    @Autowired
    StudentMapper studentMapper;

    @Override
    public List<Student> list() {
        return studentMapper.list();
    }

    @Override
    public PageInfo<Student> page(BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPageNum(), baseRequest.getPageSize());
        List<Student> students = studentMapper.listByCondition(baseRequest);
        PageInfo<Student> studentPageInfo = new PageInfo<>(students);
        return studentPageInfo;
    }

    @Override
    public void save(Student student) {
//        Date date = new Date();
//        //当作学号来处理
//        student.setName(DateUtil.format(date, "yyyyMMdd") + IdUtil.fastSimpleUUID());
        studentMapper.save(student);
    }

    @Override
    public Student getBySno(String sno) {
        return studentMapper.getBySno(sno);
    }

    @Override
    public void update(Student student) {
        studentMapper.updateBySno(student);
    }

    @Override
    public void deleteBySno(String sno) {
        studentMapper.deleteBySno(sno);
    }

    @Override
    public LoginDTO login(LoginRequest request) {
        Student student = studentMapper.getBySnoAndPassword(request);
        if (student == null) {
            throw new ServiceException("用户名或密码错误");
        }
        LoginDTO loginDTO = new LoginDTO();
        BeanUtils.copyProperties(student, loginDTO);
        return loginDTO;
    }
}
