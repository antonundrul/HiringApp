package com.company.hiringapp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "skills")
@Getter
@Setter
@NoArgsConstructor
public class Skill extends AbstractEntity {
    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "skills")
    private List<Resume>  resumes = new ArrayList<>();

   /* @ManyToMany(mappedBy = "skills")
    private List<Vacancy>  vacancies = new ArrayList<>();*/
}
