package com.company.hiringapp.entity;

import javax.persistence.*;

@Entity
@Table(name="vacancy_skill_sets")
public class VacancySkillSet extends AbstractEntity{
    @ManyToOne
    @JoinColumn(name = "vacancy_id")
    private Vacancy vacancy;

    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;

    @Column(name = "skill_level")
    private int skillLevel;
}
