package com.devmanish.user.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.devmanish.user.dto.Department;
import com.devmanish.user.dto.ResponseTemplate;
import com.devmanish.user.entity.User;
import com.devmanish.user.repository.UserRepository;

@Service
public class UserService {

	private static final Logger log = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private UserRepository userRepository;

	public User saveUser(User user) {
		log.info("Inside UserService in saveUser method ");
		return userRepository.save(user);
	}

	public ResponseTemplate getUserWithDepartment(Long userId) {
		log.info("Inside UserService in getUserWithDepartment method ");
		ResponseTemplate rt = new ResponseTemplate();
		User user = userRepository.findByUserId(userId);

		Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(),
				Department.class);

		rt.setUser(user);
		rt.setDepartment(department);
		return rt;
	}
}
