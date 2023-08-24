package com.exam.service;

import com.exam.entity.Admin;

import java.util.List;

/**
 * @author weidie
 */
public interface AdminService{

    List<Admin> findAll();

    Admin findById(Integer adminId);

    int deleteById(int adminId);

    int update(Admin admin);

    int add(Admin admin);
}
