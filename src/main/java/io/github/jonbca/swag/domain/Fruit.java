package io.github.jonbca.swag.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.common.base.MoreObjects;

import javax.validation.constraints.NotNull;
import java.util.Objects;

@JsonTypeName("Fruit")
public class Fruit extends Food {
    private final String kind;

    @JsonCreator
    public Fruit(@JsonProperty("name") String name, @JsonProperty("kind") String kind) {
        super(name);
        this.kind = kind;
    }

    @NotNull
    public String getKind() {
        return kind;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("kind", kind)
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
        Fruit fruit = (Fruit) o;
        return Objects.equals(kind, fruit.kind);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), kind);
    }
}
