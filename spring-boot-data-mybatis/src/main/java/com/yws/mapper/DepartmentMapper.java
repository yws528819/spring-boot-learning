package com.yws.mapper;

import com.yws.bean.Department;
import org.apache.ibatis.annotations.*;

//@Mapper
public interface DepartmentMapper {

    @Select("select * from department where id = #{id}")
    public Department getDeptById(Integer id);

    @Delete("delete from department where id = #{id}")
    public int deleteDepById(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into department (department_Name) values(#{departmentName})")
    public int insertDept(Department department);

    @Update("update department set department_Name=#{departmentName} where id = #{id}")
    public int updateDept(Department department);
}
