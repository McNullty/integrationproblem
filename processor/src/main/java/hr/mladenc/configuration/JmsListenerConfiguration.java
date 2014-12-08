/**
 *
 */
package hr.mladenc.configuration;

import javax.inject.Inject;
import javax.jms.ConnectionFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

/**
 * @author mladenc
 *
 */
@Configuration
@Profile("jms")
@EnableJms
public class JmsListenerConfiguration {
    @Bean
    @Inject
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(final ConnectionFactory cf) {
        final DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(cf);

        return factory;
    }
}
