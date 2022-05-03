package com.company.hiringapp.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class VacancySkillDTO extends AbstractDTO{
    private VacancyDTO vacancy;
    private SkillDTO skill;
    private LevelDTO level;

}
