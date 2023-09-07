package com.example.springboot.mapper;

import com.example.springboot.controller.request.BaseRequest;
import com.example.springboot.controller.request.LoginRequest;
import com.example.springboot.entity.Admin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface AdminMapper {

    List<Admin> list();

    List<Admin> listByCondition(BaseRequest baseRequest);

    void save(Admin admin);

    Admin getByAccount(String account);

    void updateByAccount(Admin admin);

    void deleteByAccount(String account);

    Admin getByAccountAndPassword(LoginRequest request);

    void resetPassword(String account);
}
