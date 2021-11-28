package com.company.hiringapp.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "job_types")
@Getter
@Setter
@EqualsAndHashCode
public class JobType extends AbstractEntity{
    @Column(name = "name")
    private String name;
}
