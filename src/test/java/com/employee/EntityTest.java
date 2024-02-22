package com.employee;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import com.employee.entity.Employee;

@RunWith(SpringRunner.class)
public class EntityTest {

	@InjectMocks
	Employee employee;

	@Test
	public void testID() {
		employee.setId(1);
		assertEquals(1, employee.getId());
	}

	@Test
	public void testName() {
		employee.setFirstName("ABC");
		assertEquals("ABC", employee.getFirstName());
	}

	@Test
	public void testLastName() {
		employee.setLastName("PQR");
		assertEquals("PQR", employee.getLastName());
	}

	@Test
	public void testEmail() {
		employee.setEmail("abc@anj.com");
		assertEquals("abc@anj.com", employee.getEmail());
	}

	@Test
	public void testDesignation() {
		employee.setDesignation("HR");
		assertEquals("HR", employee.getDesignation());
	}

	@Test
	public void testConstrctor() {

		Employee emp = new Employee(1, "AA", "BB", "abc@pqr", "HR");

		assertEquals(1, emp.getId());
		assertEquals("AA", emp.getFirstName());
		assertEquals("BB", emp.getLastName());
		assertEquals("abc@pqr", emp.getEmail());
		assertEquals("HR", emp.getDesignation());
	}

	@Test
	public void testToString() {
		Employee emp = new Employee(1, "AA", "BB", "abc@pqr", "HR");
		String toStringResult = emp.toString();

		assertEquals(toStringResult, new Employee(1, "AA", "BB", "abc@pqr", "HR").toString());
		
	}

}
