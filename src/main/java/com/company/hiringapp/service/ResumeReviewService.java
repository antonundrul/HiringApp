package com.company.hiringapp.service;

import com.company.hiringapp.dto.*;

import java.util.List;

public interface ResumeReviewService {
    ResumeReviewDTO save(ResumeReviewDTO dto);
    void delete(Long reviewId);
    ResumeReviewDTO findById(Long id);
    List<ResumeReviewDTO> findByResume(ResumeDTO resumeDTO);
    List<ResumeReviewDTO> findByRecruiter(RecruiterDTO recruiterDTO);
}
