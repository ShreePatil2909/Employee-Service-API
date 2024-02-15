package com.employee.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dto.Employee_DTO;
import com.employee.entity.Employee;
import com.employee.exception.ResourceNotFoundException;
import com.employee.mapper.Employee_Mapper;
import com.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	Employee_Mapper employee_Mapper;

	@Override
	public Employee_DTO createEmployee(Employee_DTO employeeDTO) {

		Employee mapToEmployee = employee_Mapper.mapToEmployee(employeeDTO);
		Employee saveEmployee = employeeRepository.save(mapToEmployee);

		return employee_Mapper.mapToEmployeeDTO(saveEmployee);
	}

	@Override
	public List<Employee_DTO> retrieveAllEmployee() {

		return employeeRepository.findAll().stream().map(emp -> employee_Mapper.mapToEmployeeDTO(emp))
				.collect(Collectors.toList());
	}

	@Override
	public Employee_DTO retrieveEmployeeById(int id) {

		if (id >= 1) {
			Employee employee = employeeRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Invalide Employee Id..!!"));
			return employee_Mapper.mapToEmployeeDTO(employee);
		} else
			throw new ResourceNotFoundException(id + "This type of Id is not present..!!");
	}

	@Override
	public Employee_DTO updateEmployeeById(int id, Employee_DTO employeeDTO) {

		Employee employee = employeeRepository.findById(id).get();

//		employee.setId(employeeDTO.getId());
		employee.setFirstName(employeeDTO.getFirstName());
		employee.setLastName(employeeDTO.getLastName());
		employee.setEmail(employeeDTO.getEmail());
		employee.setDesignation(employeeDTO.getDesignation());

		Employee saveUpdateEmp = employeeRepository.save(employee);
		return employee_Mapper.mapToEmployeeDTO(saveUpdateEmp);
	}

	@Override
	public String deleteEmployeeById(int id) {

		Employee empId = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("This Employee ID doesn't exist..!!"));

		employeeRepository.delete(empId);
		return "Employee Deleted By Id..!!";
	}

	@Override
	public List<Employee_DTO> getEmployeeBySortingName() {

		return employeeRepository.findAll().stream().sorted(Comparator.comparing(Employee::getFirstName))
				.map(emp -> employee_Mapper.mapToEmployeeDTO(emp)).collect(Collectors.toList());
	}
}
