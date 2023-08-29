package com.exam.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.Teacher;
import org.apache.ibatis.annotations.*;

import java.util.List;

/** Mapper 继承该接口后，无需编写 mapper.xml 文件，即可获得CRUD功能
 * @author weidie
 */
@Mapper
public interface TeacherMapper extends BaseMapper<Teacher>{

//    @Select("select * from teacher")
    IPage<Teacher>  findAll(Page<Teacher> page);

//    @Select("select * from teacher")
    List<Teacher> findAllNoPages();

//    @Select("select * from teacher where teacherId = #{teacherId}")
    Teacher findById(Integer teacherId);

    /**
     * Mapper 继承该接口后，无需编写 mapper.xml 文件，即可获得CRUD功能
     * @param teacher
     * @return
     */
//    @Delete("delete from teacher where teacherId = #{teacherId}")
//    int deleteById(Integer teacherId);

    /**
     * Mapper 继承该接口后，无需编写 mapper.xml 文件，即可获得CRUD功能
     * @param teacher
     * @return
     */
//    @Update("update teacher set teacherName = #{teacherName},sex = #{sex}," +
//            "tel = #{tel}, email = #{email},pwd = #{pwd},cardId = #{cardId}," +
//            "role = #{role},institute = #{institute},type = #{type} where teacherId = #{teacherId}")
//    int updateById(Teacher teacher);

//    @Options(useGeneratedKeys = true,keyProperty = "teacherId")
//    @Insert("insert into teacher(teacherName,sex,tel,email,pwd,cardId,role,type,institute) " +
//            "values(#{teacherName},#{sex},#{tel},#{email},#{pwd},#{cardId},#{role},#{type},#{institute})")
    int add(Teacher teacher);
}
