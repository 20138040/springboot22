package springboot22.springboot2022.controller;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springboot22.springboot2022.entity.Department;
import springboot22.springboot2022.error.DepartmentNotFoundException;
import springboot22.springboot2022.service.IDepartment;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/department/")
public class DepartmentController {

    @Autowired
    private IDepartment departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("addDepartment")
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("Saving the department..");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("getDepartments")
    public List<Department> getDepartments(){
        return departmentService.getDepartments();
    }

    @GetMapping("getDepartment/{id}")
    public Department getDepartment(@PathVariable("id") Long id) throws DepartmentNotFoundException {
        return departmentService.getDepartment(id);
    }

    @GetMapping("getDepartment/name/{name}")
    public List<Department> getDepartmentByName(@PathVariable("name") String name){
        return departmentService.getDepartmentByName(name);
    }

    @PutMapping("updateDepartment")
    public Department updateDepartment(@Valid @RequestBody Department department){
        return departmentService.updateDepartment(department);
    }

    @DeleteMapping("deleteDepartment/{id}")
    public void deleteDepartment(@PathVariable("id") Long id){
         departmentService.deleteDepartment(id);
    }

}
