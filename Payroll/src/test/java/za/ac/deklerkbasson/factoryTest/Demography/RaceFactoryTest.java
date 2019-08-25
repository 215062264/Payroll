package za.ac.deklerkbasson.factoryTest.Demography;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.deklerkbasson.domain.demography.Race;
import za.ac.deklerkbasson.factory.demography.RaceFactory;

public class RaceFactoryTest {

    private String testName;

    @Before
    public void setUp() throws Exception {
        this.testName = "Asian";
    }

    @Test
    public void buildRace() {
        Race course = RaceFactory.buildRace(this.testName);
        Assert.assertNotNull(course.getRaceId());
        Assert.assertNotNull(course);
    }
}
