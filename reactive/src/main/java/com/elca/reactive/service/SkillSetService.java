package com.elca.reactive.service;

import com.elca.reactive.dto.SkillSetDto;

import reactor.core.publisher.Flux;

/**
 *
 * @author sdb
 */
public interface SkillSetService {

    Flux<SkillSetDto> getSkillSetsByEmployeeId(Long id);
}
