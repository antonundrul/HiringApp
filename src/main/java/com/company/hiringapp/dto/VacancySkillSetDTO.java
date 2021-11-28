package com.company.hiringapp.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class VacancySkillSetDTO extends AbstractDTO{
    private VacancyDTO vacancy;
    private SkillDTO skill;
    private int skillLevel;
}
