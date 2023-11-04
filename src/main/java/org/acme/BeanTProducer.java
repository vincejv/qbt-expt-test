package org.acme;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class BeanTProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(BeanTProducer.class);

    @ConfigProperty(name = "qbittorrent.exporter.locale")
    private String locale;

    @Produces
    BeanT qbtHttpHandler() {
        LOGGER.info("Locale {}", locale);
        return new BeanT(locale);
    }
}
