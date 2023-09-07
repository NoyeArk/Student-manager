package com.example.springboot.service.impl;

import com.example.springboot.common.exception.ServiceException;
import com.example.springboot.controller.dto.LoginDTO;
import com.example.springboot.controller.request.BaseRequest;
import com.example.springboot.controller.request.LoginRequest;
import com.example.springboot.entity.Admin;
import com.example.springboot.mapper.AdminMapper;
import com.example.springboot.service.IAdminService;
import com.example.springboot.service.IStudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.rowset.serial.SerialException;
import java.util.List;

/**
 * @BelongsProject: student-manager
 * @BelongsPackage: com.example.springboot.service.impl
 * @Author: yanhongwei
 * @CreateTime: 2023-06-29  11:38
 * @Description: TODO
 * @Version: 1.0
 */

@Slf4j
@Service
public class AdminService implements IAdminService {

    @Autowired
    AdminMapper adminMapper;

    @Override
    public List<Admin> list() {
        return adminMapper.list();
    }

    @Override
    public PageInfo<Admin> page(BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPageNum(), baseRequest.getPageSize());
        List<Admin> admins = adminMapper.listByCondition(baseRequest);
        PageInfo<Admin> adminPageInfo = new PageInfo<>(admins);
        return adminPageInfo;
    }

    @Override
    public void save(Admin admin) {
//        Date date = new Date();
//        //当作学号来处理
//        student.setName(DateUtil.format(date, "yyyyMMdd") + IdUtil.fastSimpleUUID());
        adminMapper.save(admin);
    }

    @Override
    public Admin getByAccount(String account) {
        return adminMapper.getByAccount(account);
    }

    @Override
    public void update(Admin admin) {
        adminMapper.updateByAccount(admin);
    }

    @Override
    public void deleteByAccount(String account) {
        adminMapper.deleteByAccount(account);
    }

    @Override
    public LoginDTO login(LoginRequest request) {
        Admin admin = adminMapper.getByAccountAndPassword(request);
        if (admin == null) {
            throw new ServiceException("用户名或密码错误");
        }
        LoginDTO loginDTO = new LoginDTO();
        BeanUtils.copyProperties(admin, loginDTO);
        return loginDTO;
    }

    @Override
    public void resetPassword(String account) {
        adminMapper.resetPassword(account);
    }
}
