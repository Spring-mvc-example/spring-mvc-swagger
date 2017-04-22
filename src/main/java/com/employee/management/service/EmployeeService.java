package com.employee.management.service;

import java.util.List;

import com.employee.management.model.Employee;

public interface EmployeeService {
	public void saveEmployee(Employee employee);

	public List<Employee> employeeList();

	public Employee getEmpById(int id);

	public String update(int id, String pwd, String rePwd);

	public String delete(int id);
}
