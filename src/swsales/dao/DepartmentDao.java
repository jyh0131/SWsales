package swsales.dao;

import java.util.List;

import swsales.model.Department;



public interface DepartmentDao {
	//select
	Department selectDepartmentByNo(Department dept);
	List<Department> selectDepartmentByAll();
	
	//insert, update, delete
	int insertDepartment(Department dept);
	int updateDepartment(Department dept);
	int deleteDepartment(Department dept);
}
