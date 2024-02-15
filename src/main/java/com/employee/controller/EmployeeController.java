package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dto.Employee_DTO;
import com.employee.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping("/create")
	public ResponseEntity<Employee_DTO> createEmployee(@RequestBody Employee_DTO employeeDTO) {

		Employee_DTO createEmployee = employeeService.createEmployee(employeeDTO);
		return new ResponseEntity<Employee_DTO>(createEmployee, HttpStatus.CREATED);
	}

	@GetMapping("/getAllEmployee")
	public ResponseEntity<List<Employee_DTO>> retrieveAllEmployee() {

		List<Employee_DTO> retrieveAllEmployee = employeeService.retrieveAllEmployee();
		return new ResponseEntity<List<Employee_DTO>>(retrieveAllEmployee, HttpStatus.FOUND);
	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<Employee_DTO> retrieveEmployeeById(@PathVariable int id) {

		Employee_DTO retrieveEmployeeById = employeeService.retrieveEmployeeById(id);
		return new ResponseEntity<Employee_DTO>(retrieveEmployeeById, HttpStatus.FOUND);
	}

	@PutMapping("/update")
	public ResponseEntity<Employee_DTO> updateEmployeeById(@RequestParam int id,
			@RequestBody Employee_DTO employeeDTO) {

		Employee_DTO updateEmployeeById = employeeService.updateEmployeeById(id, employeeDTO);
		return new ResponseEntity<Employee_DTO>(updateEmployeeById, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteEmployeeById(@PathVariable int id) {

		employeeService.deleteEmployeeById(id);
	}

	@GetMapping("/empName")
	public ResponseEntity<List<Employee_DTO>> getEmployeeBySortingName() {

		List<Employee_DTO> employeeBySortingName = employeeService.getEmployeeBySortingName();
		return ResponseEntity.ok(employeeBySortingName);
	}
}
