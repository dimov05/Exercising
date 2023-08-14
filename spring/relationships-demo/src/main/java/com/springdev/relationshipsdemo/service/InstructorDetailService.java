package com.springdev.relationshipsdemo.service;

import com.springdev.relationshipsdemo.entity.InstructorDetail;
import com.springdev.relationshipsdemo.repository.InstructorDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstructorDetailService {
    private InstructorDetailRepository instructorDetailRepository;

    @Autowired
    public InstructorDetailService(InstructorDetailRepository instructorDetailRepository) {
        this.instructorDetailRepository = instructorDetailRepository;
    }

    public InstructorDetail findById(int id) {
        return instructorDetailRepository.findById(id).orElseThrow(NullPointerException::new);
    }

    public void deleteById(int id) {
        instructorDetailRepository.deleteById(id);
    }
}
