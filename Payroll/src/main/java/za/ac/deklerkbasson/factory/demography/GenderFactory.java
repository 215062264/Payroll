package za.ac.deklerkbasson.factory.demography;

import za.ac.deklerkbasson.domain.demography.Gender;
import za.ac.deklerkbasson.util.Misc;

public class GenderFactory {

    public static Gender buildGender(String genderName) {
        return new Gender.Builder().genderId(Misc.generateId()).genderName(genderName).build();
    }
}
