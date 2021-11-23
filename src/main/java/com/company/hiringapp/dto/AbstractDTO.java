package com.company.hiringapp.dto;

import java.io.Serializable;

public abstract class AbstractDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    public AbstractDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "AbstractDto{" +
                "id=" + id +
                '}';
    }
}
