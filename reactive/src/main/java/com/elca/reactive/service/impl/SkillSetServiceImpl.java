package com.elca.reactive.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import com.elca.reactive.domain.Employee;
import com.elca.reactive.domain.SkillSet;
import com.elca.reactive.dto.SkillSetDto;
import com.elca.reactive.repository.EmployeeRepository;
import com.elca.reactive.repository.SkillRepository;
import com.elca.reactive.repository.SkillSetRepository;
import com.elca.reactive.service.SkillSetService;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;

/**
 *
 * @author sdb
 */
@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
public class SkillSetServiceImpl implements SkillSetService {

    private final SkillSetRepository skillSetRepository;

    private final EmployeeRepository employeeRepository;

    private final SkillRepository skillRepository;

    @Override
    public Flux<SkillSetDto> getSkillSetsByEmployeeId(Long id) {
        
        return skillSetRepository
                .findSkillSetsByEmployeeId(id)
                //.zipWith(employeeRepository.findById(Flux.just(id)), Pair::of)
                .flatMap(skillSet -> employeeRepository.findById(id)
                        .map(skill -> Pair.of(skillSet, skill)))
                .flatMap(pair -> {
                    SkillSet skillSet = pair.getFirst();
                    Employee employee = pair.getSecond();
                    return skillRepository
                            .findById(skillSet.getSkillId())
                            .map(skill -> SkillSetDto.builder()
                                    .name(employee.getFirstName() + " " + employee.getLastName())
                                    .skillName(skill.getName())
                                    .skillLevel(skillSet.getSkillLevel()).build());
                });

         /*employeeRepository.findById(id)
                .flatMapMany(employee -> skillSetRepository
                        .findSkillSetsByEmployeeId(id)
                        .flatMap(skillSet -> skillRepository
                                .findById(skillSet.getSkillId())
                                .map(skill -> SkillSetDto.builder()
                                        .name(employee.getFirstName())
                                        .skillName(skill.getName())
                                        .skillLevel(skillSet.getSkillLevel()).build()))
                );*/
    }


}
