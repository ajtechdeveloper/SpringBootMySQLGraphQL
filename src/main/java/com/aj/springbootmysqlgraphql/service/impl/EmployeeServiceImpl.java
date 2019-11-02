package com.aj.springbootmysqlgraphql.service.impl;

import com.aj.springbootmysqlgraphql.domain.Employee;
import com.aj.springbootmysqlgraphql.repository.EmployeeRepository;
import com.aj.springbootmysqlgraphql.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    public void save(Employee employeeRequest) {
        logger.info("Entering EmployeeServiceImpl.save Method with Employee Details: {}", employeeRequest.toString());
        Employee employee = new Employee();
        employee.setName(employeeRequest.getName());
        employee.setDepartment(employeeRequest.getDepartment());
        employee.setSalary(employeeRequest.getSalary());
        employeeRepository.save(employee);
        logger.info("Leaving EmployeeServiceImpl.save Method");
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public List<Employee> findByName(String name) {
        return employeeRepository.findByName(name);
    }

    @Transactional
    public int updateEmployee(Employee employeeRequest) {
        logger.info("Entering EmployeeServiceImpl.updateEmployee Method with Employee Details: {}", employeeRequest.toString());
        return employeeRepository.updateEmployee(employeeRequest.getName(), employeeRequest.getDepartment(),
                employeeRequest.getSalary(), employeeRequest.getId());
    }

    public void delete(Integer id) {
        employeeRepository.deleteById(id);
    }

    public long count() {
        return employeeRepository.count();
    }

    public Optional<Employee> findById(int id) {
        return employeeRepository.findById(id);
    }

    public boolean deleteById(Integer id) {
        boolean employeeDeleted = false;
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()) {
            employeeRepository.deleteById(id);
            employeeDeleted = true;
        }
        return employeeDeleted;
    }

    public Employee findByNameDepartmentSalary(String name, String department, Integer salary){
        return employeeRepository.findByNameAndDepartmentAndSalary(name, department,salary);
    }
}
