/**
 *
 */
package hr.mladenc.gateway.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * @author mladenc
 *
 */
@Configuration
@PropertySources(value = { @PropertySource("classpath:common.properties"),
        @PropertySource("classpath:rabbitmq.properties") })
public class PropertiesConfiguration {
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
