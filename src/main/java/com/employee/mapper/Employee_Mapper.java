package com.employee.mapper;

import org.springframework.stereotype.Component;

import com.employee.dto.Employee_DTO;
import com.employee.entity.Employee;

@Component
public class Employee_Mapper {

	public Employee mapToEmployee(Employee_DTO employeeDto) {

		Employee employee = new Employee();

		employee.setId(employeeDto.getId());
		employee.setFirstName(employeeDto.getFirstName());
		employee.setLastName(employeeDto.getLastName());
		employee.setEmail(employeeDto.getEmail());
		employee.setDesignation(employeeDto.getDesignation());

		return employee;
	}

	public Employee_DTO mapToEmployeeDTO(Employee employee) {

		Employee_DTO employeeDTO = new Employee_DTO();

		employeeDTO.setId(employee.getId());
		employeeDTO.setFirstName(employee.getFirstName());
		employeeDTO.setLastName(employee.getLastName());
		employeeDTO.setEmail(employee.getEmail());
		employeeDTO.setDesignation(employee.getDesignation());

		return employeeDTO;

	}

}
