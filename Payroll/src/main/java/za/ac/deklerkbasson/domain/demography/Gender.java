package za.ac.deklerkbasson.domain.demography;

import java.util.Objects;

public class Gender {

    private String genderId, genderName;

    private Gender() {
    }

    private Gender(Builder builder) {
        this.genderId = builder.genderId;
        this.genderName = builder.genderName;
    }

    public String getGenderId() {
        return genderId;
    }

    public String getGenderName() {
        return genderName;
    }

    @Override
    public String toString() {
        return "Gender{" +
                "genderId='" + genderId + '\'' +
                ", genderName='" + genderName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gender course = (Gender) o;
        return genderId.equals(course.genderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(genderId);
    }

    public static class Builder {

        private String genderId, genderName;

        public Builder genderId(String genderId) {
            this.genderId = genderId;
            return this;
        }

        public Builder genderName(String genderName) {
            this.genderName = genderName;
            return this;
        }

        public Builder copy(Gender course) {
            this.genderId = course.genderId;
            this.genderName = course.genderName;

            return this;
        }

        public Gender build() {
            return new Gender(this);
        }

    }
}

