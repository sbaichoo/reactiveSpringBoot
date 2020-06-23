package com.elca.reactive.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author sdb
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("employee")
public class Employee {

    @Id
    private Long id;

    private String firstName;

    private String lastName;

}
