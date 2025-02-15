package com.spring.project.jobPortal.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.project.jobPortal.entity.JobSeekerProfile;
import com.spring.project.jobPortal.entity.RecruiterProfile;
import com.spring.project.jobPortal.entity.Users;
import com.spring.project.jobPortal.repository.JobSeekerProfileRepository;
import com.spring.project.jobPortal.repository.RecruiterProfileRepository;
import com.spring.project.jobPortal.repository.UsersRepository;

@Service
public class UsersService {

	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private JobSeekerProfileRepository jobSeekerProfileRepository;
	
	@Autowired
	private RecruiterProfileRepository recruiterProfileRepository;
	
	public Users addNewUser(Users users) {
		users.setActive(true);
		users.setRegistrationDate(new java.util.Date(System.currentTimeMillis()));
		Users savedUser=usersRepository.save(users);
		int userTypeId = users.getUserTypeId().getUserTypeId();
		if(userTypeId==1) {
			recruiterProfileRepository.save(new RecruiterProfile(users));
		}else{
			jobSeekerProfileRepository.save(new JobSeekerProfile(users));
		}
		return savedUser;
		
	}
	
	public Optional<Users> findByEmail(String email) {
		return usersRepository.findByEmail(email);
	}
}
