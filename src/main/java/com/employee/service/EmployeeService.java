package com.employee.service;

import java.util.List;

import com.employee.dto.Employee_DTO;

public interface EmployeeService {

	Employee_DTO createEmployee(Employee_DTO employeeDTO);
	
	List<Employee_DTO> retrieveAllEmployee();

	Employee_DTO retrieveEmployeeById(int id);

	Employee_DTO updateEmployeeById(int id, Employee_DTO employeeDTO);

	String deleteEmployeeById(int id);

	List<Employee_DTO> getEmployeeBySortingName(); 

}  
