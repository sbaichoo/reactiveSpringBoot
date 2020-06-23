package com.elca.reactive.service;

import com.elca.reactive.domain.Employee;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author sdb
 */
public interface EmployeeService {
    Mono<Employee> getEmployeeById(Long id);

    Flux<Employee> findAllEmployees();

    Mono<Employee> updateEmployeeById(Long id, Employee employee);
}
