package io.github.jonbca.swag.domain;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;
import org.junit.Test;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.assertj.core.api.Assertions.assertThat;

public class FruitTest {
    private final ObjectMapper mapper = Jackson.newObjectMapper();

    @Test
    public void testDeserialisesToFruit() throws Exception {
        final Fruit fruit = new Fruit("strawberry", "bush");

        final Food food = mapper.readValue(fixture("fixtures/fruit.json"), Food.class);

        assertThat(food).isEqualTo(fruit);
    }

    @Test
    public void testSerialisesFruit() {
        final Food fruitAsFood = new Fruit("strawberry", "bush");

        JsonNode asNode = mapper.valueToTree(fruitAsFood);

        assertThat(asNode.get("name").asText()).isEqualTo("strawberry");
        assertThat(asNode.get("preferenceType").asText()).isEqualTo("Fruit");
    }
}