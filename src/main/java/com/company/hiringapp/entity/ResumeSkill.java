package com.company.hiringapp.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "resume_skills")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class ResumeSkill extends AbstractEntity{
    @ManyToOne
    @JoinColumn(name = "resume_id")
    private Resume resume;
    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;
    @ManyToOne
    @JoinColumn(name = "level_id")
    private Level level;

}
