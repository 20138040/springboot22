package springboot22.springboot2022.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot22.springboot2022.entity.Department;

import java.util.List;

public interface DepartmentRepo extends JpaRepository<Department, Long> {

    List<Department> findAllByDepartmentName(String name);
}
