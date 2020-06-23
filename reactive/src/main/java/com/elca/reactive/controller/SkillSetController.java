package com.elca.reactive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elca.reactive.dto.SkillSetDto;
import com.elca.reactive.service.SkillSetService;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;

/**
 *
 * @author sdb
 */
@RestController()
@RequestMapping(value = "/api/skillsets")
@AllArgsConstructor(onConstructor_ = @Autowired)
public class SkillSetController {

    private SkillSetService skillSetService;

    @GetMapping("/{id}")
    public Flux<SkillSetDto> getSkillSetsByEmployeeId(@PathVariable("id") Long id) {
        return skillSetService.getSkillSetsByEmployeeId(id);
    }

}
