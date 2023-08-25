package com.exam.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.Teacher;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author weidie
 */
@Mapper
public interface TeacherMapper extends BaseMapper<Teacher> {

//    @Select("select * from teacher")
    IPage<Teacher>  findAll(Page<Teacher> page);

//    @Select("select * from teacher")
    public List<Teacher> findAllNoPages();

//    @Select("select * from teacher where teacherId = #{teacherId}")
    public Teacher findById(Integer teacherId);

//    @Delete("delete from teacher where teacherId = #{teacherId}")
    public int deleteById(Integer teacherId);

//    @Update("update teacher set teacherName = #{teacherName},sex = #{sex}," +
//            "tel = #{tel}, email = #{email},pwd = #{pwd},cardId = #{cardId}," +
//            "role = #{role},institute = #{institute},type = #{type} where teacherId = #{teacherId}")
    public int update(Teacher teacher);

//    @Options(useGeneratedKeys = true,keyProperty = "teacherId")
//    @Insert("insert into teacher(teacherName,sex,tel,email,pwd,cardId,role,type,institute) " +
//            "values(#{teacherName},#{sex},#{tel},#{email},#{pwd},#{cardId},#{role},#{type},#{institute})")
    public int add(Teacher teacher);
}
