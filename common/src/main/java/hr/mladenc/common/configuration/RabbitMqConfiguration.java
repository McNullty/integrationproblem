/**
 *
 */
package hr.mladenc.common.configuration;

import hr.mladenc.common.reciver.AmqpMessageReceiver;
import hr.mladenc.common.sender.AmqpMessageSender;

import javax.inject.Inject;

import org.springframework.amqp.core.AmqpAdmin;
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

    @Bean
    public ConnectionFactory connectionFactory() {
        final CachingConnectionFactory connectionFactory = new CachingConnectionFactory(
                this.env.getProperty("rabitmq.hostname"));
        return connectionFactory;
    }

    @Bean
    public AmqpAdmin amqpAdmin() {
        final RabbitAdmin ra = new RabbitAdmin(connectionFactory());

        return ra;
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        final RabbitTemplate template = new RabbitTemplate(connectionFactory());

        return template;
    }

    @Bean
    @Profile(value = { "amqp-gateway" })
    public AmqpMessageSender getSender() {
        final AmqpMessageSender sender = new AmqpMessageSender(rabbitTemplate());
        sender.setQueue(this.env.getProperty("queue.name"));

        return sender;
    }

    @Bean
    @Profile(value = { "amqp-processor" })
    public AmqpMessageReceiver getReceiver() {
        return new AmqpMessageReceiver(rabbitTemplate());
    }
}
