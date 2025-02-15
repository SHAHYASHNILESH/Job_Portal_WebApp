package com.spring.project.jobPortal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.project.jobPortal.entity.UsersType;
import com.spring.project.jobPortal.repository.UsersTypeRepository;

@Service
public class UsersTypeService {

	@Autowired
	private UsersTypeRepository usersTypeRepository;

	public List<UsersType> getAllUsersType() {

		return usersTypeRepository.findAll();
	}
}
