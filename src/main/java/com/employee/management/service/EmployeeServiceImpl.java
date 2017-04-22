package com.employee.management.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employee.management.dao.EmployeeDAO;
import com.employee.management.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeDAO employeeDAO;

	@Transactional
	public void saveEmployee(Employee employee) {
		employeeDAO.saveEmployee(employee);
	}

	@Transactional
	public List<Employee> employeeList() {
		return employeeDAO.employeeList();
	}

	public Employee getEmpById(int id) {
		return employeeDAO.getEmployee(id);
	}

	public String update(int id, String pwd, String rePwd) {
		return employeeDAO.updatePassword(id, pwd, rePwd);
	}

	public String delete(int id) {
		return employeeDAO.deleteEmployee(id);
	}
}
