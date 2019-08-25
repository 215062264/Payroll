package za.ac.deklerkbasson.serviceTest.Demography;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import za.ac.deklerkbasson.domain.demography.Gender;
import za.ac.deklerkbasson.factory.demography.GenderFactory;
import za.ac.deklerkbasson.repositoryTest.demography.Impl.GenderRepositoryImpl;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class GenderServiceImplTest {

    private GenderRepositoryImpl repository;
    private Gender gender;

    private Gender getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = GenderRepositoryImpl.getGenderRepositoryImpl();
        this.gender = GenderFactory.buildGender("Male");
    }

    @Test
    public void a_create() {
        Gender created = this.repository.create(this.gender);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.gender);
    }

    @Test
    public void c_update() {
        String newGenderName = "Application Development Theory 3";
        Gender updated = new Gender.Builder().copy(getSaved()).genderName(newGenderName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newGenderName, updated.getGenderName());
    }

    @Test
    public void e_delete() {
        Gender saved = getSaved();
        this.repository.delete(saved.getGenderId());
        d_getAll();
    }

    @Test
    public void b_read() {
        Gender saved = getSaved();
        Gender read = this.repository.read(saved.getGenderId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<Gender> genders = this.repository.getAll();
        System.out.println("In getall, all = " + genders);
    }
}