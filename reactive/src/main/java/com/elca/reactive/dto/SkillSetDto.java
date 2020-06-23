package com.elca.reactive.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 *
 * @author sdb
 */
@Data
@AllArgsConstructor
@Builder
public class SkillSetDto {

    private String name;
    private String skillName;
    private String skillLevel;

}
