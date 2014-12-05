/**
 *
 */
package hr.mladenc.gateway.configuration;

import hr.mladenc.gateway.sender.JmsMessageSender;

import javax.inject.Inject;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.jms.core.JmsMessagingTemplate;

/**
 * @author mladenc
 *
 */
@Configuration
@Profile(value = { "jms" })
public class ActiveMqConfiguration {

    @Inject
    private Environment env;

    @Bean
    public ActiveMQConnectionFactory getConnectionFactory() {
        final ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory();
        cf.setBrokerURL("tcp://" + this.env.getProperty("activemq.hostname") + ":"
                + this.env.getProperty("activemq.port"));

        return cf;
    }

    @Bean
    public ActiveMQQueue getDestination() {
        final ActiveMQQueue queue = new ActiveMQQueue(this.env.getProperty("queue.name"));
        return queue;
    }

    @Bean
    public JmsMessagingTemplate getJmsTemplate() {
        final JmsMessagingTemplate template = new JmsMessagingTemplate(getConnectionFactory());
        template.setDefaultDestination(getDestination());

        return template;
    }

    @Bean
    public JmsMessageSender getMessageSender() {
        return new JmsMessageSender(getJmsTemplate());
    }
}
