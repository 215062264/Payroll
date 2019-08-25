package za.ac.deklerkbasson.factoryTest.Demography;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.deklerkbasson.domain.demography.Gender;
import za.ac.deklerkbasson.factory.demography.GenderFactory;

public class GenderFactoryTest {

    private String testName;

    @Before
    public void setUp() throws Exception {
        this.testName = "Male";
    }

    @Test
    public void buildGender() {
        Gender course = GenderFactory.buildGender(this.testName);
        Assert.assertNotNull(course.getGenderId());
        Assert.assertNotNull(course);
    }
}
