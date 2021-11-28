package com.company.hiringapp.entity;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "currencies")
@Getter
@Setter
@EqualsAndHashCode
public class Currency extends AbstractEntity{

    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;

}
