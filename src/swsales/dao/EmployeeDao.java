package swsales.dao;

import java.util.List;

import swsales.model.Department;
import swsales.model.Employee;



public interface EmployeeDao {
	//select
	List<Employee> selectEmployeeByAll();
	List<Employee> selectEmployeeListByDeptName(Department dept);
	
	Employee selectEmployeeByNo(Employee emp);
	Employee selectEmployeeByDept(Employee emp);
	Employee selectEmployeebyLastNo();
	Employee loginEmployee(Employee emp);
	Employee selectEmployeeByID(Employee emp);
	Employee selectEmployeeByID2(Employee emp);
	Employee selectEmployeeByMail(Employee emp);
	String selectEmployeeName(String name);

	
	
	//insert, update, delete
	int insertEmployee(Employee emp);
	int updateEmployee(Employee emp);
	int updateEmpPassword(Employee emp);
	int deleteEmployee(Employee emp);
	

}
