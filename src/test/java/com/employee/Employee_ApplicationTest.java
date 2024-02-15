package com.employee;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.employee.controller.EmployeeController;
import com.employee.dto.Employee_DTO;
import com.employee.service.EmployeeService;

@RunWith(SpringRunner.class)
public class Employee_ApplicationTest {

	@InjectMocks
	EmployeeController employeeController;

	@Mock
	EmployeeService employeeService;

	@Mock
	Employee_DTO employee_dto;

	// Create
	@Test
	public void createEmployee_Test() {

		Mockito.when(employeeService.createEmployee(Mockito.any())).thenReturn(employee_dto);
		assertEquals(HttpStatus.CREATED, employeeController.createEmployee(employee_dto).getStatusCode());
		assertEquals(employee_dto, employeeController.createEmployee(employee_dto).getBody());
	}

	// Get AllEmployee
	@Test
	public void retrieveAllEmployee_Test() {

		List<Employee_DTO> list = new ArrayList<>();
		list.add(employee_dto);

		when(employeeService.retrieveAllEmployee()).thenReturn(list);
		employeeController.retrieveAllEmployee();
	}

	// Get ById
	@Test
	public void retrieveEmployeeById_Test() {
		
		when(employeeService.retrieveEmployeeById(1)).thenReturn(employee_dto);
		assertEquals(employee_dto, employeeController.retrieveEmployeeById(1).getBody());
	}

	// Update Employee
	@Test
	public void updateEmployeeById_Test() {
		
		when(employeeService.updateEmployeeById(2, employee_dto)).thenReturn(employee_dto);
		employeeController.updateEmployeeById(2, employee_dto);
	}

	// Delete Employee
	@Test
	public void deleteById_Test() {

		doNothing().when(employeeService.deleteEmployeeById(Mockito.anyInt()));
		employeeController.deleteEmployeeById(1);
		verify(employeeService).deleteEmployeeById(1);

	}

	// SortedByName
	@Test
	public void getEmployeeBySortingName_Test() {

		List<Employee_DTO> list = new ArrayList<>();
		list.add(employee_dto);

		when(employeeService.getEmployeeBySortingName()).thenReturn(list);
		employeeController.getEmployeeBySortingName();
	}

}