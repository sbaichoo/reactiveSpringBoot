package com.elca.reactive.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
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
@Table("skill_set")
public class SkillSet {

    @Id
    private Long id;

    private Long employeeId;

    private Long skillId;

    @Column("skill_level")
    private String skillLevel;

}