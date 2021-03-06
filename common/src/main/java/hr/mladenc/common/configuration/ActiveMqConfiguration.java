/**
 *
 */
package hr.mladenc.common.configuration;

import hr.mladenc.common.sender.JmsMessageSender;

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

    public ActiveMQQueue getDestination() {
        final ActiveMQQueue queue = new ActiveMQQueue(this.env.getProperty("queue.name"));
        return queue;
    }

    public JmsMessagingTemplate getJmsTemplate() {
        final JmsMessagingTemplate template = new JmsMessagingTemplate(getConnectionFactory());
        template.setDefaultDestination(getDestination());

        return template;
    }

    @Bean
    @Profile(value = { "jms-gateway" })
    public JmsMessageSender getMessageSender() {
        final JmsMessageSender sender = new JmsMessageSender(getJmsTemplate());
        sender.setQueue(this.env.getProperty("queue.name"));

        return sender;
    }

}
