package com.usermanagement.commons.repository;

import com.usermanagement.commons.exception.UMException;
import com.usermanagement.commons.model.Employee;

public interface EmployeeRepository {
	public Employee saveEmployee(Employee employee) throws UMException;
}
