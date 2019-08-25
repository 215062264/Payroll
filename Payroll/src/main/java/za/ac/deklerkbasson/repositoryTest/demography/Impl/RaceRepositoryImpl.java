package za.ac.deklerkbasson.repositoryTest.demography.Impl;

import za.ac.deklerkbasson.domain.demography.Race;
import za.ac.deklerkbasson.repositoryTest.demography.RaceRepository;

import java.util.HashSet;
import java.util.Set;

public class RaceRepositoryImpl implements RaceRepository {
    private static RaceRepositoryImpl repository = null;
    private static RaceRepositoryImpl raceRepositoryImpl = null;
    private Set<Race> races;

    private RaceRepositoryImpl() {
        this.races = new HashSet<>();
    }

    public static RaceRepositoryImpl getRaceRepositoryImpl() {
        if (raceRepositoryImpl == null) {
            raceRepositoryImpl = new RaceRepositoryImpl();
        }
        return raceRepositoryImpl;
    }

    private Race findRace(String raceId) {
        return this.races.stream()
                .filter(race -> race.getRaceId().trim().equals(raceId))
                .findAny()
                .orElse(null);
    }

    public Race create(Race race) {
        this.races.add(race);
        return race;
    }

    public Race read(final String raceId) {
        Race race = findRace(raceId);
        return race;
    }

    public void delete(String raceId) {
        Race race = findRace(raceId);
        if (race != null) this.races.remove(race);
    }

    public Race update(Race race) {
        Race toDelete = findRace(race.getRaceId());
        if (toDelete != null) {
            this.races.remove(toDelete);
            return create(race);
        }
        return null;
    }


    public Set<Race> getAll() {
        return this.races;
    }
}

