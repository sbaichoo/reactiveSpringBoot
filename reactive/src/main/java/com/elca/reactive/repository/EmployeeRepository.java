package com.elca.reactive.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.elca.reactive.domain.Employee;

/**
 *
 * @author sdb
 */
@Repository
public interface EmployeeRepository extends ReactiveCrudRepository<Employee, Long> {

/*
    Flux<Employee> findEmployeeById(Long id);
*/

    
}
