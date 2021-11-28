package com.company.hiringapp.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "resume_skill_sets")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class ResumeSkillSet extends AbstractEntity{
    @ManyToOne
    @JoinColumn(name = "resume_id")
    private Resume resume;

    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;

    @Column(name = "skill_level")
    private int skillLevel;
}
