package za.ac.deklerkbasson.repositoryTest.demography;

import za.ac.deklerkbasson.domain.demography.Race;
import za.ac.deklerkbasson.repositoryTest.IRepository;

import java.util.Set;

public interface RaceRepository extends IRepository<Race, String> {
    Set<Race> getAll();
}
