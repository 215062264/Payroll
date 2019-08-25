package za.ac.deklerkbasson.service.demography;

import za.ac.deklerkbasson.domain.demography.Race;
import za.ac.deklerkbasson.service.IService;

import java.util.Set;

public interface RaceService extends IService<Race, String> {
    Set<Race> getAll();
}
