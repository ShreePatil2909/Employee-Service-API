package com.employee;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.employee.dto.Employee_DTO;
import com.employee.entity.Employee;
import com.employee.mapper.Employee_Mapper;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeServiceImpl;

@RunWith(SpringRunner.class)
public class EmployeeService {

	@InjectMocks
	EmployeeServiceImpl employeeService;

	@Mock
	Employee_Mapper mapper;

	@Mock
	Employee emp;

	@Mock
	Employee_DTO dto;

	@Mock
	EmployeeRepository repo;

	@Test
	public void testCreateEmployee() {
		
		when(mapper.mapToEmployee(dto)).thenReturn(emp);
		employeeService.createEmployee(dto);
	}

	@Test
	public void testRetrieveById() {
		
		when(repo.findById(1)).thenReturn(Optional.of(emp));
		when(mapper.mapToEmployeeDTO(emp)).thenReturn(dto);
		employeeService.retrieveEmployeeById(1);
	}

	@Test
	public void testRetrieveAll() {

		List<Employee> list = new ArrayList<>();
		list.add(new Employee(1, "AA", "BB", "abc@adfg", "HR"));

		when(repo.findAll()).thenReturn(list);
	}

	@Test
	public void testUpdateEmployee() {

		Employee employee = new Employee(1, "AA", "BB", "abc@adfg", "HR");

		when(repo.findById(1)).thenReturn(Optional.of(emp));

		emp.setId(dto.getId());
		emp.setFirstName(dto.getFirstName());
		emp.setLastName(dto.getLastName());
		emp.setEmail(dto.getEmail());
		emp.setDesignation(dto.getDesignation());

		when(repo.save(emp)).thenReturn(employee);
		mapper.mapToEmployeeDTO(employee);
	}

	@Test
	public void testDeleteEmployee() {
		Employee employee = new Employee(1, "AA", "BB", "abc@adfg", "HR");
		repo.deleteById(employee.getId());
		verify(repo,times(1)).deleteById(1); 
	}
	
	@Test
	public void testSortedEmployee() {
		List<Employee> list = new ArrayList<>();
		list.add(new Employee(1, "AA", "BB", "abc@adfg", "HR"));

		when(repo.findAll()).thenReturn(list);
		when(mapper.mapToEmployeeDTO(emp)).thenReturn(dto);
	}

}
