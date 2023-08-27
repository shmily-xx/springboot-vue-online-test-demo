package com.exam.controller;

import com.exam.entity.Admin;
import com.exam.service.AdminService;
import com.exam.serviceimpl.AdminServiceImpl;
import com.exam.util.Res;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author weidie
 */
@RestController
public class AdminController {

    private final AdminService adminService;
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }
    @Autowired
    public AdminController(AdminServiceImpl adminService){
        this.adminService = adminService;
    }

    @GetMapping("/admins")
    public Res<List<Admin>> findAll(){
        return Res.success(adminService.findAll());
    }

    @GetMapping("/admin/{adminId}")
    public Res<Admin> findById(@PathVariable("adminId") Integer adminId){
        return Res.success(adminService.findById(adminId));
    }

    @DeleteMapping("/admin/{adminId}")
    public Res<String> deleteById(@PathVariable("adminId") Integer adminId){
        adminService.deleteById(adminId);
        return Res.success();
    }

    @PutMapping("/admin/{adminId}")
    public Res<Integer> update(@PathVariable("adminId") Integer adminId, Admin admin){
        return Res.success(adminService.update(admin));
    }

    @PostMapping("/admin")
    public Res<Integer> add(Admin admin){
        return Res.success(adminService.add(admin));
    }
}
