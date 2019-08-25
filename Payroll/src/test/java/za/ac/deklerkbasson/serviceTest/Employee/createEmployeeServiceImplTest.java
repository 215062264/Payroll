package za.ac.deklerkbasson.serviceTest.Employee;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import za.ac.deklerkbasson.domain.user.Employee;
import za.ac.deklerkbasson.service.user.Impl.createEmployeeServiceImpl;

import java.util.UUID;

import static org.junit.Assert.assertNotNull;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class createEmployeeServiceImplTest {

    private createEmployeeServiceImpl createEmployee;


    @Before
    public void setUp() throws Exception {
        createEmployee = new createEmployeeServiceImpl();

    }


    @Test
    public void a_saveEmployee() {
        Employee employee1 = createEmployee.saveEmployee(UUID.randomUUID().toString(), "Deklerk", "Basson", 23, "Male", "Asian");
        System.out.println("Created employee: " + employee1 + "\n");
        assertNotNull(employee1);
        assertNotNull(createEmployee.empRepository.getAll());
    }

    @Test
    public void b_getEmployeeGender() {

        System.out.println("This employee's gender is: " + createEmployee.genderRepository.getAll() + "\n");
        assertNotNull(createEmployee.genderRepository.getAll());
    }

    @Test
    public void c_getEmployeeRace() {

        System.out.println("This employee's race is: " + createEmployee.raceRepository.getAll() + "\n");
        assertNotNull(createEmployee.raceRepository.getAll());
    }

}