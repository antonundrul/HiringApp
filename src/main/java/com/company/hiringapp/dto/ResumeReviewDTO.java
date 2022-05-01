package com.company.hiringapp.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class ResumeReviewDTO extends AbstractDTO {
    private RecruiterDTO recruiter;
    private ResumeDTO resume;
    private String comment;
    private LocalDate dateCreated;
}
