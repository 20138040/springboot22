package springboot22.springboot2022.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import springboot22.springboot2022.entity.Department;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
//@AutoConfigureTestDatabase()

class DepartmentRepoTest {

    @Autowired
    private DepartmentRepo departmentRepo;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {

        Department department = Department.builder()
                .departmentName("IT")
                .departmentCode("it")
                .departmentAddress("blr")
                .build();

        entityManager.persist(department);
    }

    @Test
    public void getDepartmentByIdTest(){
        Department department = departmentRepo.findById(1L).get();
        assertEquals(department.getDepartmentName(), "IT");

    }
}