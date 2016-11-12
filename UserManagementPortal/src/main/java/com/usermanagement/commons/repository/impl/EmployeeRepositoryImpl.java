package com.usermanagement.commons.repository.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.usermanagement.commons.exception.UMException;
import com.usermanagement.commons.model.Employee;
import com.usermanagement.commons.repository.EmployeeRepository;

@Repository("userRepository")
public class EmployeeRepositoryImpl implements EmployeeRepository {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Employee saveEmployee(Employee employee) throws UMException {
		return sessionFactory.getCurrentSession().saveOrUpdate(employee);
	}

}
