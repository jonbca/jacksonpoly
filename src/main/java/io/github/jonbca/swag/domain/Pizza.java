package io.github.jonbca.swag.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableSet;

import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

@JsonTypeName("PIZZA_TYPE")
public class Pizza extends Food {
    private final ImmutableSet<String> toppings;

    @JsonCreator
    public Pizza(@JsonProperty("name") String name, @JsonProperty("toppings") Set<String> toppings) {
        super(name);
        this.toppings = ImmutableSet.copyOf(toppings);
    }

    @NotNull
    public Set<String> getToppings() {
        return toppings;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("toppings", toppings)
                          .toString();
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
        Pizza pizza = (Pizza) o;
        return Objects.equals(toppings, pizza.toppings);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), toppings);
    }
}
