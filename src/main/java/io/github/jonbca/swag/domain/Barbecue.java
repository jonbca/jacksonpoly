package io.github.jonbca.swag.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.common.base.MoreObjects;

import java.util.Objects;

@JsonTypeName("BARBECUE_TYPE")
public class Barbecue extends Food {
    private final String animal;

    @JsonCreator
    public Barbecue(@JsonProperty("name") String name, @JsonProperty("animal") String animal) {
        super(name);
        this.animal = animal;
    }

    public String getAnimal() {
        return animal;
    }

    @Override
    public PreferenceType getFoodPreference() {
        return PreferenceType.BARBECUE_TYPE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Barbecue barbecue = (Barbecue) o;
        return Objects.equals(animal, barbecue.animal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), animal);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("animal", animal)
                          .add("name", name)
                          .toString();
    }
}
