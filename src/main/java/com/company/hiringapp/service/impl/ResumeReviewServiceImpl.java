package com.company.hiringapp.service.impl;

import com.company.hiringapp.dto.RecruiterDTO;
import com.company.hiringapp.dto.ResumeDTO;
import com.company.hiringapp.dto.ResumeReviewDTO;
import com.company.hiringapp.dto.mapper.RecruiterMapper;
import com.company.hiringapp.dto.mapper.ResumeMapper;
import com.company.hiringapp.dto.mapper.ResumeReviewMapper;
import com.company.hiringapp.entity.ResumeReview;
import com.company.hiringapp.exception.ResourceNotFoundException;
import com.company.hiringapp.repository.ResumeReviewRepository;
import com.company.hiringapp.service.ResumeReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeReviewServiceImpl implements ResumeReviewService {
    @Autowired private ResumeReviewRepository resumeReviewRepository;
    @Autowired private ResumeReviewMapper resumeReviewMapper;
    @Autowired private ResumeMapper resumeMapper;
    @Autowired private RecruiterMapper recruiterMapper;


    @Override
    public ResumeReviewDTO save(ResumeReviewDTO dto) {
        resumeReviewRepository.save(resumeReviewMapper.toEntity(dto));
        return dto;
    }

    @Override
    public void delete(Long reviewId) {
        ResumeReview resumeReview = resumeReviewRepository.findById(reviewId).orElseThrow(() -> new ResourceNotFoundException(reviewId));
        resumeReviewRepository.delete(resumeReview);
    }

    @Override
    public ResumeReviewDTO findById(Long id) {
        ResumeReview resumeReview = resumeReviewRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        return resumeReviewMapper.toDto(resumeReview);
    }

    @Override
    public List<ResumeReviewDTO> findByResume(ResumeDTO resumeDTO) {
        return resumeReviewMapper.toDtoList(resumeReviewRepository.findByResume(resumeMapper.toEntity(resumeDTO)));
    }

    @Override
    public List<ResumeReviewDTO> findByRecruiter(RecruiterDTO recruiterDTO) {

        return resumeReviewMapper.toDtoList(resumeReviewRepository.findByRecruiter(recruiterMapper.toEntity(recruiterDTO)));
    }
}
