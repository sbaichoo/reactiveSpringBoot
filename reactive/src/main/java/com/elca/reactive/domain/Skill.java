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
@Table("skill")
public class Skill {

    @Id
    private Long id;

    private String name;

    private String description;

}
