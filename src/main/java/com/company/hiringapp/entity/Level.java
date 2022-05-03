package com.company.hiringapp.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "levels")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Level extends AbstractEntity{
    @Column(name = "name")
    private String name;
}
