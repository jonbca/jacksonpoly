package io.github.jonbca.swag.domain;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.common.base.MoreObjects;

@JsonTypeName("Barbecue")
public class Barbecue extends Food {
    private final String animal;

    public Barbecue(String name, String animal) {
        super(name);
        this.animal = animal;
    }

    public String getAnimal() {
        return animal;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("animal", animal)
                          .toString();
    }
}
