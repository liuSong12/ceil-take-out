package com.sky.mapper;

import com.sky.dto.EmployeeLoginDTO;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import com.sky.result.PageResult;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    /**
     * 根据用户名查询员工
     * @param username
     * @return
     */
    @Select("select * from employee where username = #{username}")
    Employee getByUsername(String username);

    /**
     * 新增员工
     *
     * @param employee
     */
    @Insert("insert into employee(username, password, name, phone,sex,id_number, status, create_time, update_time, create_user, update_user) " +
            "values(#{username}, #{password}, #{name}, #{phone},#{sex},#{idNumber}, #{status}, #{createTime},#{updateTime}, #{createUser}, #{updateUser})")
    void save(Employee employee);

    List<Employee> pageQuery(String name, int page, int pageSize);

    @Select("select count(*) from employee")
    long total();
}
