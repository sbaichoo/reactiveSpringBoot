package com.elca.reactive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elca.reactive.domain.Employee;
import com.elca.reactive.service.EmployeeService;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author sdb
 */
@RestController()
@RequestMapping(value = "/api/employees")
@AllArgsConstructor(onConstructor_ = @Autowired)
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Employee>> getEmployeeById(@PathVariable("id") Long id) {
        return employeeService.getEmployeeById(id).map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping
    public Flux<Employee> findAllEmployees() {
        return employeeService.findAllEmployees();
    }

    @PutMapping("/{id}")
    public Mono<Employee> updateEmployeeById(@PathVariable Long id, @RequestBody Employee employee) {
        return employeeService.updateEmployeeById(id, employee);
    }


}
