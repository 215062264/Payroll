package za.ac.deklerkbasson.serviceTest.Demography;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import za.ac.deklerkbasson.domain.demography.Race;
import za.ac.deklerkbasson.factory.demography.RaceFactory;
import za.ac.deklerkbasson.repositoryTest.demography.Impl.RaceRepositoryImpl;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class RaceServiceImplTest {

    private RaceRepositoryImpl repository;
    private Race race;

    private Race getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = RaceRepositoryImpl.getRaceRepositoryImpl();
        this.race = RaceFactory.buildRace("Asian");
    }

    @Test
    public void a_create() {
        Race created = this.repository.create(this.race);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.race);
    }

    @Test
    public void c_update() {
        String newRaceName = "Asian";
        Race updated = new Race.Builder().copy(getSaved()).raceName(newRaceName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newRaceName, updated.getRaceName());
    }

    @Test
    public void e_delete() {
        Race saved = getSaved();
        this.repository.delete(saved.getRaceId());
        d_getAll();
    }

    @Test
    public void b_read() {
        Race saved = getSaved();
        Race read = this.repository.read(saved.getRaceId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<Race> races = this.repository.getAll();
        System.out.println("In getall, all = " + races);
    }
}