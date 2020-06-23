package com.elca.reactive.router;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.elca.reactive.repository.EmployeeRepository;

import lombok.AllArgsConstructor;

/**
 *
 * @author sdb
 */
@Configuration
@AllArgsConstructor(onConstructor_ = @Autowired)
public class EmployeeRouter {

    private final EmployeeRepository employeeRepository;
    
}
