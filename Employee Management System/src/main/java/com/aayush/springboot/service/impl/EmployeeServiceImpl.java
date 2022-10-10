package com.aayush.springboot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aayush.springboot.exception.ResourceNotFoundException;
import com.aayush.springboot.model.Employee;
import com.aayush.springboot.repository.EmployeeRepository;
import com.aayush.springboot.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if (employee.isPresent()) {
			return employee.get();
		} else {
			throw new ResourceNotFoundException("Employee", "Id", id);
		}
	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		// Checking whether employee with given id exists or not
		Employee existingEmployee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));

		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());

		// Saving existing employee to database
		employeeRepository.save(existingEmployee);

		return existingEmployee;
	}

	@Override
	public void deleteEmployee(long id) {
		// Checking whether given employee exists within database or not
		employeeRepository.findById(id).orElseThrow(() -> 
							new ResourceNotFoundException("Employee", "Id", id));

		employeeRepository.deleteById(id);
	}
}
