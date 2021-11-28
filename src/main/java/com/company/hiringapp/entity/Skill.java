package com.company.hiringapp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "skills")
@Getter
@Setter
@NoArgsConstructor
public class Skill extends AbstractEntity {
    @Column(name = "name")
    private String name;
}
