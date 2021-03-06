package com.company.hiringapp.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class ResumeSkillDTO extends AbstractDTO{
    private ResumeDTO resume;
    private SkillDTO skill;
    private LevelDTO level;
}
