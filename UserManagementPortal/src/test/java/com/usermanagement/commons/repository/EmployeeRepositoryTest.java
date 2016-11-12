package com.usermanagement.commons.repository;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.usermanagement.commons.exception.UMException;
import com.usermanagement.commons.model.Department;
import com.usermanagement.commons.model.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "UserManagementPortal-servlet.xml" })
public class EmployeeRepositoryTest {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	DepartmentRepository departmentRepository;

	public EmployeeRepositoryTest() {
	}

	@BeforeClass
	public static void setUpClass() throws Exception {
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
	}

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	@Test
	public void testSaveEmployee() {
		Department department = new Department();
		department.setDepartmentName("Sales");
		try {
			departmentRepository.saveDepartment(department);
			Employee emp = new Employee("Nina", "Mayers", "111");
			emp.setDepartment(department);
			employeeRepository.saveEmployee(emp);
		} catch (UMException e) {
			e.printStackTrace();
		}
	}
}
