package io.github.jonbca.swag;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.github.jonbca.swag.configuration.SwagConfiguration;
import io.github.jonbca.swag.resources.FoodResource;
import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;
import org.eclipse.jetty.servlets.CrossOriginFilter;

import javax.servlet.DispatcherType;
import java.util.EnumSet;

public class App extends Application<SwagConfiguration> {

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void initialize(Bootstrap<SwagConfiguration> bootstrap) {
        super.initialize(bootstrap);
    }

    public void run(SwagConfiguration swagConfiguration, Environment environment) throws Exception {
        environment.jersey().register(FoodResource.class);
        environment.jersey().register(OpenApiResource.class);

        environment.servlets()
                   .addFilter("corsFilter", CrossOriginFilter.class)
                   .addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST),
                                             true, "/*");

    }

    public static void main(String... args) throws Exception {
        new App().run(args);
    }
}
