package com.learn.springboot.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.springboot.thymeleafdemo.dao.EmployeeRepository;
import com.learn.springboot.thymeleafdemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeDAO;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeDAO) {
		employeeDAO=theEmployeeDAO;
	}


	@Override
	public List<Employee> findAll() {
		List<Employee> emp=employeeDAO.findAllByOrderByLastNameAsc();
		return emp;
	}

	@Override
	public Employee findById(int theId) {
		Optional<Employee> result = employeeDAO.findById(theId);
		Employee emp=null;
		if(result.isPresent()) {
			emp=result.get()	;
		}
		else {
			throw new RuntimeException("Did not find employee id-"+theId);
		}
		return emp;
	}

	@Override
	public void save(Employee theEmployee) {
		employeeDAO.save(theEmployee);
	}

	@Override
	public void deleteById(int theId) {
		employeeDAO.deleteById(theId);
	}

}
