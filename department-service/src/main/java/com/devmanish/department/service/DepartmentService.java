package com.devmanish.department.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmanish.department.entity.Department;
import com.devmanish.department.repository.DepartmentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentService {

	private static final Logger log = LoggerFactory.getLogger(DepartmentService.class);

	@Autowired
	private DepartmentRepository departmentRepository;

	public Department saveDepartment(Department department) {
		log.info("Inside savedepartment of Department Service");
		return departmentRepository.save(department);
	}

	public Department findByDepartmentId(Long departmentId) {
		log.info("Inside findDepartmentById of Department Service");
		return departmentRepository.findByDepartmentId(departmentId);
	}
}
