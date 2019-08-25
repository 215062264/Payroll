package za.ac.deklerkbasson.repositoryTest.demography.Impl;

import za.ac.deklerkbasson.domain.demography.Gender;
import za.ac.deklerkbasson.repositoryTest.demography.GenderRepository;

import java.util.HashSet;
import java.util.Set;

public class GenderRepositoryImpl implements GenderRepository {
    private static GenderRepositoryImpl repository = null;
    private static GenderRepositoryImpl genderRepositoryImpl = null;
    private Set<Gender> genders;

    private GenderRepositoryImpl() {
        this.genders = new HashSet<>();
    }

    public static GenderRepositoryImpl getGenderRepositoryImpl() {
        if (genderRepositoryImpl == null) {
            genderRepositoryImpl = new GenderRepositoryImpl();
        }
        return genderRepositoryImpl;
    }

    private Gender findGender(String genderId) {
        return this.genders.stream()
                .filter(gender -> gender.getGenderId().trim().equals(genderId))
                .findAny()
                .orElse(null);
    }

    public Gender create(Gender gender) {
        this.genders.add(gender);
        return gender;
    }

    public Gender read(final String genderId) {
        Gender gender = findGender(genderId);
        return gender;
    }

    public void delete(String genderId) {
        Gender gender = findGender(genderId);
        if (gender != null) this.genders.remove(gender);
    }

    public Gender update(Gender gender) {
        Gender toDelete = findGender(gender.getGenderId());
        if (toDelete != null) {
            this.genders.remove(toDelete);
            return create(gender);
        }
        return null;
    }


    public Set<Gender> getAll() {
        return this.genders;
    }
}
