/**
 *
 */
package hr.mladenc.gateway;

import hr.mladenc.common.configuration.ActiveMqConfiguration;
import hr.mladenc.common.configuration.RabbitMqConfiguration;
import hr.mladenc.common.constants.Constants;
import hr.mladenc.gateway.configuration.GatewayConfiguration;
import hr.mladenc.gateway.configuration.PropertiesConfiguration;
import hr.mladenc.gateway.configuration.RootConfiguration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author mladenc
 *
 */
public class WebAppInitializer implements WebApplicationInitializer {
    final static Logger log = LoggerFactory.getLogger(WebAppInitializer.class);

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.web.WebApplicationInitializer#onStartup(javax.servlet.ServletContext)
     */
    @Override
    public void onStartup(final ServletContext container) throws ServletException {

        // TODO: Provjeriti je li potreban logback-test.xml
        // The definition of the Root Spring Container shared by all Servlets and Filters
        final AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        // TODO: Provjeriti je li potrebna ROOT konfiguracija
        rootContext.register(RootConfiguration.class);
        rootContext.getEnvironment().setActiveProfiles(addActiveProfiles());

        // Creates the Spring Container shared by all Servlets and Filters
        container.addListener(new ContextLoaderListener(rootContext));

        // Create the dispatcher servlet's Spring application context
        final AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
        dispatcherContext.register(PropertiesConfiguration.class, GatewayConfiguration.class,
                RabbitMqConfiguration.class, ActiveMqConfiguration.class);

        // Register and map the dispatcher servlet
        final ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new DispatcherServlet(
                dispatcherContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");

    }

    /**
     * @return
     */
    private String addActiveProfiles() {
        return Constants.SPRING_JMS_PROFILE;
    }
}
