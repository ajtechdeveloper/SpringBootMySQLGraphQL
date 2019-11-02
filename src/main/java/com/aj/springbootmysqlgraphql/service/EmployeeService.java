package com.aj.springbootmysqlgraphql.service;

import com.aj.springbootmysqlgraphql.domain.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    void save(Employee employee);
    List<Employee> findAll();
    List<Employee> findByName(String name);
    int updateEmployee(Employee employeeRequest);
    void delete(Integer id);
    long count();
    Optional<Employee> findById(int id);
    boolean deleteById(Integer id);
    Employee findByNameDepartmentSalary(String name, String department, Integer salary);
}
