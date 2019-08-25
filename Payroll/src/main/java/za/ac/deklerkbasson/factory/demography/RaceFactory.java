package za.ac.deklerkbasson.factory.demography;

import za.ac.deklerkbasson.domain.demography.Race;
import za.ac.deklerkbasson.util.Misc;

public class RaceFactory {

    public static Race buildRace(String raceName) {
        return new Race.Builder().raceId(Misc.generateId()).raceName(raceName).build();
    }
}
