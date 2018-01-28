package io.github.jonbca.swag.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeId;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.validation.constraints.NotNull;
import java.util.Objects;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "foodPreference",
        visible = true)
@JsonSubTypes({@JsonSubTypes.Type(Fruit.class),
               @JsonSubTypes.Type(Barbecue.class),
               @JsonSubTypes.Type(Pizza.class)})
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class Food {
    final String name;

    Food(String name) {
        this.name = name;
    }

    @NotNull
    public final String getName() {
        return name;
    }

    @NotNull
    @JsonTypeId
    public abstract PreferenceType getFoodPreference();

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Food food = (Food) o;
        return Objects.equals(name, food.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
