package za.ac.deklerkbasson.repositoryTest.demography;

import za.ac.deklerkbasson.domain.demography.Gender;
import za.ac.deklerkbasson.repositoryTest.IRepository;

import java.util.Set;

public interface GenderRepository extends IRepository<Gender, String> {
    Set<Gender> getAll();
}
