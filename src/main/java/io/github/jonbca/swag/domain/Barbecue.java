package io.github.jonbca.swag.domain;

import com.google.common.base.MoreObjects;

public class Barbecue extends Food {
    private final String animal;

    public Barbecue(String name, String animal) {
        super(name);
        this.animal = animal;
    }

    @Override
    public PreferenceType getPreferenceType() {
        return PreferenceType.BARBECUE;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("animal", animal)
                          .toString();
    }
}
