package io.github.jonbca.swag.resources;

import io.github.jonbca.swag.domain.Barbecue;
import io.github.jonbca.swag.domain.Fruit;
import io.github.jonbca.swag.domain.Pizza;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/food-preferences")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FoodResource {
    private static final Logger LOG = LoggerFactory.getLogger(FoodResource.class);

    @POST
    public Response savePizzaPreference(@Valid Pizza pizza) {
        LOG.info("Called the pizza {}", pizza);
        return Response.ok().build();
    }

    @POST
    public Response saveFruitPreference(@Valid Fruit fruit) {
        LOG.info("Called the fruit {}", fruit);
        return Response.ok().build();
    }

    @POST
    public Response saveBarbecuePreference(@Valid Barbecue barbecue) {
        LOG.info("Called the barbecue {}", barbecue);
        return Response.ok().build();
    }
}
