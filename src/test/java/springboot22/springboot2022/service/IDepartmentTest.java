package springboot22.springboot2022.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import springboot22.springboot2022.entity.Department;
import springboot22.springboot2022.repository.DepartmentRepo;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IDepartmentTest {

    @Autowired
    private IDepartment iDepartment;

    @MockBean
    private DepartmentRepo departmentRepo;

    @BeforeEach
    void setUp() {

        Department department = new Department(1L, "IT","Bangalore","it");
        List<Department> ls = new ArrayList<>();
        Mockito.when(departmentRepo.findAllByDepartmentName("IT"))
                .thenReturn(ls);
    }

    @Test
    @DisplayName("Get all department based on name")
    public  void getDepartmentByNameTest(){
        String name = "IT";
        List<Department> department = iDepartment.getDepartmentByName(name);

        for (Department dept: department) {
            assertEquals(name, dept.getDepartmentName());
        }
    }
}