package com.employee.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.management.model.Employee;
import com.employee.management.service.EmployeeService;
import com.employee.management.util.Acknowledgement;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveEmployee(@RequestBody Employee employee) {
		employeeService.saveEmployee(employee);
	}

	@RequestMapping(value = "/getEmployee", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> employeeList() {
		return employeeService.employeeList();
	}

	@RequestMapping(value = "/getEmployeeById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee getSpecificEmployee(@PathVariable("id") int id) {
		return employeeService.getEmpById(id);
	}

	@RequestMapping(value = "/passwordUpdate/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public Acknowledgement upadtePassword(@PathVariable("id") int id, @RequestParam("password") String password,
			@RequestParam("confirmPassword") String confirmPassword) {
		String message = employeeService.update(id, password, confirmPassword);
		Acknowledgement acknowledgement = new Acknowledgement();
		acknowledgement.setStatus(message);
		return acknowledgement;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Acknowledgement deleteEmployee(@PathVariable("id") int id) {
		Acknowledgement acknowledgement = new Acknowledgement();
		acknowledgement.setStatus(employeeService.delete(id));
		return acknowledgement;
	}
}
