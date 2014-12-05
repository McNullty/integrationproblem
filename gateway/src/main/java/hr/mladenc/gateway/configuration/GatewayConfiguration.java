/**
 *
 */
package hr.mladenc.gateway.configuration;

import hr.mladenc.model.message.MessageValidator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Configuration for Gateway Servlet
 *
 * @author mladenc
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "hr.mladenc.gateway.rest" })
public class GatewayConfiguration {

    @Bean
    public MessageValidator getValidator() {
        return new MessageValidator();
    }
}
