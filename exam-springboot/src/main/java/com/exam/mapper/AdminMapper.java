package com.exam.mapper;

import com.exam.entity.Admin;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AdminMapper {

    //    @Select("select adminName,sex,tel,email,cardId,role from admin")
    List<Admin> findAll();

    //    @Select("select adminName,sex,tel,email,cardId,role from admin where adminId = #{adminId}")
    Admin findById(Integer adminId);

    //    @Delete("delete from admin where adminId = #{adminId}")
    int deleteById(int adminId);

    //    @Update("update admin set adminName = #{adminName},sex = #{sex}," +
//            "tel = #{tel}, email = #{email},pwd = #{pwd},cardId = #{cardId},role = #{role} where adminId = #{adminId}")
    int update(Admin admin);

    //    @Options(useGeneratedKeys = true,keyProperty = "adminId")
//    @Insert("insert into admin(adminName,sex,tel,email,pwd,cardId,role) " +
//            "values(#{adminName},#{sex},#{tel},#{email},#{pwd},#{cardId},#{role})")
    int add(Admin admin);
}
