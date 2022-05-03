package com.company.hiringapp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class SkillsList {
    private List<SkillDTO> skillsList;
    private List<LevelDTO> levelsList;
}
