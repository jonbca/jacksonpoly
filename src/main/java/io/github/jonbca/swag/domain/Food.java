package io.github.jonbca.swag.domain;

import com.google.common.base.MoreObjects;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public abstract class Food {
    private final String name;

    Food(String name) {
        this.name = name;
    }

    @NotNull
    public String getName() {
        return name;
    }

    @NotNull
    public abstract PreferenceType getPreferenceType();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return Objects.equals(name, food.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("name", name)
                .toString();
    }
}
