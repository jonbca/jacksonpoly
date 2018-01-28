package io.github.jonbca.swag.domain;

import com.google.common.base.MoreObjects;

import javax.validation.constraints.NotNull;

public class Fruit extends Food {
    private final String kind;

    public Fruit(String name, String kind) {
        super(name);
        this.kind = kind;
    }

    @Override
    @NotNull
    public PreferenceType getPreferenceType() {
        return PreferenceType.FRUIT;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("kind", kind)
                          .toString();
    }
}
