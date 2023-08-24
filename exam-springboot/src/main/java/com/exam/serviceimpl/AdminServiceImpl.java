package com.exam.serviceimpl;

import com.exam.entity.Admin;
import com.exam.mapper.AdminMapper;
import com.exam.service.AdminService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author weidie
 */
@Service
public class AdminServiceImpl implements AdminService {

    private final AdminMapper adminMapper;

    public AdminServiceImpl(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    @Override
    public List<Admin> findAll() {
        return adminMapper.findAll();
    }

    @Override
    public Admin findById(Integer adminId) {
        return adminMapper.findById(adminId);
    }

    @Override
    public int deleteById(int adminId) {
        return adminMapper.deleteById(adminId);
    }

    @Override
    public int update(Admin admin) {
        return adminMapper.update(admin);
    }

    @Override
    public int add(Admin admin) {
        return 0;
    }
}
