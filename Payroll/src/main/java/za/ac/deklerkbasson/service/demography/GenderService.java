package za.ac.deklerkbasson.service.demography;

import za.ac.deklerkbasson.domain.demography.Gender;
import za.ac.deklerkbasson.service.IService;

import java.util.Set;

public interface GenderService extends IService<Gender, String> {
    Set<Gender> getAll();
}
