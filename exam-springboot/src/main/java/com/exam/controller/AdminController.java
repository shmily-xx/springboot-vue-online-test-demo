package com.exam.controller;

import com.exam.entity.Admin;
import com.exam.entity.ApiResult;
import com.exam.service.AdminService;
import com.exam.serviceimpl.AdminServiceImpl;
import com.exam.util.ApiResultHandler;
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
    public ApiResult<List<Admin>> findAll(){
        return ApiResultHandler.success(adminService.findAll());
    }

    @GetMapping("/admin/{adminId}")
    public ApiResult<Admin> findById(@PathVariable("adminId") Integer adminId){
        return ApiResultHandler.success(adminService.findById(adminId));
    }

    @DeleteMapping("/admin/{adminId}")
    public ApiResult<String> deleteById(@PathVariable("adminId") Integer adminId){
        adminService.deleteById(adminId);
        return ApiResultHandler.success();
    }

    @PutMapping("/admin/{adminId}")
    public ApiResult<Integer> update(@PathVariable("adminId") Integer adminId, Admin admin){
        return ApiResultHandler.success(adminService.update(admin));
    }

    @PostMapping("/admin")
    public ApiResult<Integer> add(Admin admin){
        return ApiResultHandler.success(adminService.add(admin));
    }
}
