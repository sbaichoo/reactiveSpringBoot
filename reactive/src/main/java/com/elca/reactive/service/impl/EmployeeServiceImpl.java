package com.elca.reactive.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elca.reactive.domain.Employee;
import com.elca.reactive.repository.EmployeeRepository;
import com.elca.reactive.service.EmployeeService;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author sdb
 */
@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public Mono<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Flux<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Mono<Employee> updateEmployeeById(Long id, Employee employee) {
        return employeeRepository.findById(id)
                .log()
                .flatMap(emp -> {
                    emp.setFirstName(employee.getFirstName());
                    emp.setLastName(employee.getLastName());
                    return employeeRepository.save(emp);
                });
    }


}
