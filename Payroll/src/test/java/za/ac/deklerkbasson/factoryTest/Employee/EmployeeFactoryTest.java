package za.ac.deklerkbasson.factoryTest.Employee;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.deklerkbasson.domain.user.Employee;
import za.ac.deklerkbasson.factory.user.EmployeeFactory;

public class EmployeeFactoryTest {

    private String testFirstName;
    private String testLastName;
    private int testAge;

    @Before
    public void setUp() throws Exception {
        this.testFirstName = "testName";
        this.testLastName = "testName";
        this.testAge = 25;
    }

    @Test
    public void buildEmployee() {
        Employee course = EmployeeFactory.buildEmployee(this.testFirstName, this.testLastName, this.testAge);
        Assert.assertNotNull(course.getEmployeeID());
        Assert.assertNotNull(course);
    }
}

