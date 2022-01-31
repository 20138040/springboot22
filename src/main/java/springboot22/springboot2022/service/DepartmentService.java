package springboot22.springboot2022.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot22.springboot2022.entity.Department;
import springboot22.springboot2022.error.DepartmentNotFoundException;
import springboot22.springboot2022.repository.DepartmentRepo;

import java.util.List;

@Service
public class DepartmentService implements IDepartment{

    @Autowired
    private DepartmentRepo departmentRepo;


    @Override
    public Department saveDepartment(Department department){
        return departmentRepo.save(department);
    }

    @Override
    public List<Department> getDepartments() {
        return departmentRepo.findAll();
    }

    @Override
    public Department getDepartment(Long id) throws DepartmentNotFoundException {
        return departmentRepo.findById(id).orElseThrow(() -> new DepartmentNotFoundException("Department with "+id +" not exist"));
    }

    @Override
    public void deleteDepartment(Long id) {
         departmentRepo.deleteById(id);
    }

    @Override
    public Department updateDepartment(Department department) {
        return departmentRepo.save(department);
    }

    @Override
    public List<Department> getDepartmentByName(String name) {
        return departmentRepo.findAllByDepartmentName(name);
    }
}
