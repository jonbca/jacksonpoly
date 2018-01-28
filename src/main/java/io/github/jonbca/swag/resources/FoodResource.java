package io.github.jonbca.swag.resources;

import io.github.jonbca.swag.domain.Food;
import io.swagger.v3.oas.annotations.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/food-preferences")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FoodResource {
    private static final Logger LOG = LoggerFactory.getLogger(FoodResource.class);

    @POST
    public Response saveFoodPreference(@Valid @Parameter final Food food) {
        LOG.info("Passed food parameter {}", food);
        return Response.ok(food).build();
    }

//    @POST
//    public Response savePizzaPreference(@Valid @RequestBody Pizza pizza) {
//        LOG.info("Called the pizza {}", pizza);
//        return Response.ok().build();
//    }
//
//    @POST
//    public Response saveFruitPreference(@Valid @RequestBody Fruit fruit) {
//        LOG.info("Called the fruit {}", fruit);
//        return Response.ok().build();
//    }
//
//    @POST
//    public Response saveBarbecuePreference(@Valid @RequestBody Barbecue barbecue) {
//        LOG.info("Called the barbecue {}", barbecue);
//        return Response.ok().build();
//    }
}
