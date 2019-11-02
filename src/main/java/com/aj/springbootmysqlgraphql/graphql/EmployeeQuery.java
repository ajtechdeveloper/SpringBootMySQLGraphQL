package com.aj.springbootmysqlgraphql.graphql;

import com.aj.springbootmysqlgraphql.domain.Employee;
import com.aj.springbootmysqlgraphql.service.EmployeeService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeQuery implements GraphQLQueryResolver {

    @Autowired
    private EmployeeService employeeservice;

    public List<Employee> getEmployees() {
        return employeeservice.findAll();
    }

    public long countEmployees () {
        return employeeservice.count();
    }

    public Optional<Employee> getEmployee(final int id) {
        return employeeservice.findById(id);
    }
}
