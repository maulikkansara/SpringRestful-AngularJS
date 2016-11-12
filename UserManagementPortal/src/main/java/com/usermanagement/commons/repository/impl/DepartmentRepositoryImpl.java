package com.usermanagement.commons.repository.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.usermanagement.commons.exception.UMException;
import com.usermanagement.commons.model.Department;
import com.usermanagement.commons.repository.DepartmentRepository;

public class DepartmentRepositoryImpl implements DepartmentRepository {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Department saveDepartment(Department department) throws UMException {
		return sessionFactory.getCurrentSession().saveOrUpdate(employee);
	}

}
