/**
 *
 */
package hr.mladenc.configuration;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

/**
 * @author mladenc
 *
 */
@Configuration
@Profile("amqp")
public class AmqpListenerConfiguration {

    @Resource(name = "amqpMessageListener")
    private MessageListener listener;

    @Inject
    private Environment env;

    @Bean
    @Inject
    public SimpleMessageListenerContainer messageListenerContainer(final ConnectionFactory cf) {
        final SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(cf);
        container.setQueueNames(this.env.getProperty("queue.name"));
        container.setMessageListener(this.listener);

        return container;
    }
}
