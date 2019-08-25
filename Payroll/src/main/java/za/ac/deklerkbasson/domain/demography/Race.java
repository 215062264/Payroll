package za.ac.deklerkbasson.domain.demography;

import java.util.Objects;

public class Race {

    private String raceId, raceName;

    private Race() {
    }

    private Race(Builder builder) {
        this.raceId = builder.raceId;
        this.raceName = builder.raceName;
    }

    public String getRaceId() {
        return raceId;
    }

    public String getRaceName() {
        return raceName;
    }

    @Override
    public String toString() {
        return "Race{" +
                "raceId='" + raceId + '\'' +
                ", raceName='" + raceName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Race race = (Race) o;
        return raceId.equals(race.raceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(raceId);
    }

    public static class Builder {

        private String raceId, raceName;

        public Builder raceId(String raceId) {
            this.raceId = raceId;
            return this;
        }

        public Builder raceName(String raceName) {
            this.raceName = raceName;
            return this;
        }

        public Builder copy(Race race) {
            this.raceId = race.raceId;
            this.raceName = race.raceName;

            return this;
        }

        public Race build() {
            return new Race(this);
        }

    }
}

