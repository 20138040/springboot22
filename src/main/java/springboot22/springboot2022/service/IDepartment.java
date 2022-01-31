package springboot22.springboot2022.service;

import springboot22.springboot2022.entity.Department;
import springboot22.springboot2022.error.DepartmentNotFoundException;

import java.util.List;

public interface IDepartment {

     Department saveDepartment(Department department);

     List<Department> getDepartments();

     Department getDepartment(Long id) throws DepartmentNotFoundException;

     void deleteDepartment(Long id);

     Department updateDepartment(Department department);

     List<Department> getDepartmentByName(String name);
}
