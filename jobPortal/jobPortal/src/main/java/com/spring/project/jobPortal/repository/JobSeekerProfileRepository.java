package com.spring.project.jobPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.project.jobPortal.entity.JobSeekerProfile;

public interface JobSeekerProfileRepository extends JpaRepository<JobSeekerProfile, Integer> {

}
