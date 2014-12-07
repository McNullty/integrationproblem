/**
 *
 */
package hr.mladenc.common.configuration;

import hr.mladenc.common.sender.AmqpMessageSender;

import javax.inject.Inject;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

/**
 * @author mladenc
 *
 */
@Configuration
@Profile(value = { "amqp" })
public class RabbitMqConfiguration {

    @Inject
    private Environment env;

    public ConnectionFactory connectionFactory() {
        final CachingConnectionFactory connectionFactory = new CachingConnectionFactory(
                this.env.getProperty("rabitmq.hostname"));
        return connectionFactory;
    }

    public AmqpAdmin amqpAdmin() {
        return new RabbitAdmin(connectionFactory());
    }

    public RabbitTemplate rabbitTemplate() {
        final RabbitTemplate template = new RabbitTemplate(connectionFactory());
        template.setRoutingKey(this.env.getProperty("queue.name"));

        return template;
    }

    public Queue messageGatewayQueue() {
        return new Queue(this.env.getProperty("queue.name"));
    }

    @Bean
    @Profile(value = { "amqp-gateway" })
    public AmqpMessageSender getSender() {
        return new AmqpMessageSender(rabbitTemplate());
    }
}
