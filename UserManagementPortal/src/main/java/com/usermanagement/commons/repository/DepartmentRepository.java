package com.usermanagement.commons.repository;

import com.usermanagement.commons.exception.UMException;
import com.usermanagement.commons.model.Department;

public interface DepartmentRepository {
	public Department saveDepartment(Department department) throws UMException;
}
