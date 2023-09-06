package com.example.springboot.service;

import com.example.springboot.controller.dto.LoginDTO;
import com.example.springboot.controller.request.BaseRequest;
import com.example.springboot.controller.request.LoginRequest;
import com.example.springboot.entity.Admin;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IAdminService {

    List<Admin> list();

    PageInfo<Admin> page(BaseRequest baseRequest);

    void save(Admin admin);

    Admin getByAccount(String account);

    void update(Admin admin);

    void deleteByAccount(String account);

//    LoginDTO login(LoginRequest request);
    LoginDTO login(LoginRequest loginRequest);

    void resetPassword(String account);
}
