package com.company.hiringapp.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "vacancies")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Vacancy extends AbstractEntity{
    @Column(name = "position")
    private String position;
    @Column(name = "description")
    private String description;
    @Column(name = "salary")
    private int salary;
    @ManyToOne
    @JoinColumn(name = "currency_id")
    private Currency currency;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "req_experience")
    private int reqExperience;
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
    @ManyToOne
    @JoinColumn(name = "recruiter_id")
    private User recruiter;
    @ManyToOne
    @JoinColumn(name = "job_type_id")
    private JobType jobType;
    @Column(name = "create_date")
    private LocalDate createDate;

    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(name = "responses",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "vacancy_id"))
    private List<User> responses = new ArrayList<>();

}
