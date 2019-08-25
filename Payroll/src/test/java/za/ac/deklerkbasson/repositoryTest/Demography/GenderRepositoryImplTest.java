package za.ac.deklerkbasson.repositoryTest.Demography;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import za.ac.deklerkbasson.domain.demography.Gender;
import za.ac.deklerkbasson.factory.demography.GenderFactory;
import za.ac.deklerkbasson.repositoryTest.demography.GenderRepository;
import za.ac.deklerkbasson.repositoryTest.demography.Impl.GenderRepositoryImpl;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GenderRepositoryImplTest {

    private GenderRepository repository;
    private Gender gender;

    private Gender getSavedGender() {
        Set<Gender> savedGenders = this.repository.getAll();
        return savedGenders.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = GenderRepositoryImpl.getGenderRepositoryImpl();
        this.gender = GenderFactory.buildGender("Test Gender");
    }

    @Test
    public void a_create() {
        Gender created = this.repository.create(this.gender);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.gender);
    }

    @Test
    public void b_read() {
        Gender savedGender = getSavedGender();
        System.out.println("In read, genderId = "+ savedGender.getGenderId());
        Gender read = this.repository.read(savedGender.getGenderId());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedGender, read);
    }

    @Test
    public void e_delete() {
        Gender savedGender = getSavedGender();
        this.repository.delete(savedGender.getGenderId());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newname = "New Test Gender Name";
        Gender gender = new Gender.Builder().copy(getSavedGender()).genderName(newname).build();
        System.out.println("In update, about_to_updated = " + gender);
        Gender updated = this.repository.update(gender);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getGenderName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Gender> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
