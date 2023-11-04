package org.acme;

import io.quarkus.logging.Log;
import io.vertx.core.http.HttpServerResponse;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

@Path("/hello")
public class GreetingResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(GreetingResource.class);

    @Inject
    BeanT beanT;

    @GET
    public void hello(HttpServerResponse serverResponse) throws ParseException {
        serverResponse.putHeader("Content-Type", "text/plain;charset=utf-8");
        LOGGER.info("Locale hello() {}", beanT.getLocale());
        double v = NumberFormat.getInstance(beanT.getLocale()).parse("0,27").doubleValue();
        serverResponse.send(String.valueOf(v));
    }
}
