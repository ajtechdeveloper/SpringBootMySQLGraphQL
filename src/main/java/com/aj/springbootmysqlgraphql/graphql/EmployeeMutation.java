package com.aj.springbootmysqlgraphql.graphql;

import com.aj.springbootmysqlgraphql.domain.Employee;
import com.aj.springbootmysqlgraphql.service.EmployeeService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMutation implements GraphQLMutationResolver {

    @Autowired
    private EmployeeService employeeService;

    public Employee newEmployee (String name, String department, Integer salary) {
        Employee employee = new Employee ();
        employee.setName(name);
        employee.setDepartment(department);
        employee.setSalary(salary);
        employeeService.save(employee);
        Employee newEmployee = employeeService.findByNameDepartmentSalary(name, department, salary);
        return newEmployee;
    }

    public boolean deleteEmployee (Integer id) {
        return employeeService.deleteById(id);
    }
}
