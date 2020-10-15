package com.yws.mapper;

import com.yws.bean.Employee;
import org.apache.ibatis.annotations.*;

@Mapper
public interface EmployeeMapper {
    @Select("select * from employee where id=#{id}")
    public Employee getEmpById(Integer id);

    @Update("update employee set lastName=#{lastName}, email=#{email}, gender=#{gender}, d_Id=#{did} where id=#{id}")
    public int updateEmp(Employee employee);

    @Delete("delete from employee where id=#{id}")
    public int deleteEmp(Integer id);

    @Insert("insert into (lastName,email,gender,d_Id) values(#{lastName), #{email}, #{gender}, #{dId})")
    public int insertEmp(Employee employee);
}