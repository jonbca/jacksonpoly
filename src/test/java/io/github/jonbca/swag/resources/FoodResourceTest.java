package io.github.jonbca.swag.resources;


import com.google.common.collect.ImmutableSet;
import io.dropwizard.testing.junit.ResourceTestRule;
import io.github.jonbca.swag.domain.Barbecue;
import io.github.jonbca.swag.domain.Food;
import io.github.jonbca.swag.domain.Fruit;
import io.github.jonbca.swag.domain.Pizza;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.client.Entity;

import static org.assertj.core.api.Assertions.assertThat;

public class FoodResourceTest {
    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder().addResource(new FoodResource()).build();

    @Test
    public void serializesFruit() {
        Fruit testFood = new Fruit("apple", "treeFruit");

        final Food result = resources.target("/food-preferences")
                                     .request()
                                     .post(Entity.json(testFood), Food.class);

        assertThat(result).isEqualTo(testFood);
    }

    @Test
    public void serializesBarbecue() {
        Barbecue testFood = new Barbecue("north-carolina", "pork");

        final Food result = resources.target("/food-preferences")
                                     .request()
                                     .post(Entity.json(testFood), Food.class);

        assertThat(result).isEqualTo(testFood);
    }

    @Test
    public void serializesPizza() {
        Pizza testFood = new Pizza("hawaiian", ImmutableSet.of("pineapple", "ham", "onion"));

        final Food result = resources.target("/food-preferences")
                                     .request()
                                     .post(Entity.json(testFood), Food.class);

        assertThat(result).isEqualTo(testFood);
    }
}