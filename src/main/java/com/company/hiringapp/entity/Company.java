package com.company.hiringapp.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "companies")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Company extends AbstractEntity{
    @Column(name = "name")
    private String name;

    @Column(name = "website")
    private String website;

}
