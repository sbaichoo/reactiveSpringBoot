package com.elca.reactive.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.elca.reactive.domain.Skill;

/**
 *
 * @author sdb
 */
@Repository
public interface SkillRepository extends ReactiveCrudRepository<Skill, Long> {
}
