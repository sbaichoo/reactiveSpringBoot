package com.elca.reactive.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.elca.reactive.domain.SkillSet;

import reactor.core.publisher.Flux;

/**
 *
 * @author sdb
 */
@Repository
public interface SkillSetRepository extends ReactiveCrudRepository<SkillSet, Long> {

    Flux<SkillSet> findSkillSetsByEmployeeId(Long id);
}
