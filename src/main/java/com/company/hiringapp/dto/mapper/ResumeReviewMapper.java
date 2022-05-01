package com.company.hiringapp.dto.mapper;

import com.company.hiringapp.dto.ResumeReviewDTO;
import com.company.hiringapp.entity.ResumeReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResumeReviewMapper extends AbstractMapper<ResumeReview, ResumeReviewDTO> {
    @Autowired
    public ResumeReviewMapper() {
        super(ResumeReview.class, ResumeReviewDTO.class);
    }
}
