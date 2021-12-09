package com.company.hiringapp.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "resume")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Resume extends AbstractEntity{

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "create_date")
    private LocalDate createDate;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    private String position;

    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(name = "resume_skills",
            joinColumns = @JoinColumn(name = "resume_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private List<Skill> skills = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(name = "resume_experiences",
            joinColumns = @JoinColumn(name = "resume_id"),
            inverseJoinColumns = @JoinColumn(name = "experience_id"))
    private List<Experience> experiences = new ArrayList<>();
}
