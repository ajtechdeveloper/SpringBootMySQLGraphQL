package com.aj.springbootmysqlgraphql.repository;

import com.aj.springbootmysqlgraphql.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findByName(String name);

    @Modifying(clearAutomatically = true)
    @Query("Update Employee emp set emp.name =:name, emp.department =:department,emp.salary =:salary where emp.id =:id")
    int updateEmployee(@Param("name") String name, @Param("department") String department,
                         @Param("salary") Integer salary, @Param("id") Integer id);

    Employee findByNameAndDepartmentAndSalary(String name, String department, Integer salary);
}
