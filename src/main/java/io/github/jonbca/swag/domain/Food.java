package io.github.jonbca.swag.domain;

import com.fasterxml.jackson.annotation.*;
import com.google.common.base.MoreObjects;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotNull;
import java.util.Objects;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "foodPreference")
@JsonSubTypes({@JsonSubTypes.Type(Fruit.class),
               @JsonSubTypes.Type(Barbecue.class),
               @JsonSubTypes.Type(Pizza.class)})
public abstract class Food {
    private final String name;

    @JsonCreator
    Food(@JsonProperty("name") String name) {
        this.name = name;
    }

    @NotNull
    public String getName() {
        return name;
    }

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
