package io.github.jonbca.swag.domain;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableSet;

import javax.validation.constraints.NotNull;
import java.util.Set;

public class Pizza extends Food {
    private final ImmutableSet<String> toppings;

    public Pizza(String name, Set<String> toppings) {
        super(name);
        this.toppings = ImmutableSet.copyOf(toppings);
    }

    @NotNull
    public Set<String> getToppings() {
        return toppings;
    }

    @Override
    @NotNull
    public PreferenceType getPreferenceType() {
        return PreferenceType.PIZZA;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("toppings", toppings)
                          .toString();
    }
}
