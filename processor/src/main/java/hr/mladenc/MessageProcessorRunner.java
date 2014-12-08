/**
 *
 */
package hr.mladenc;

import hr.mladenc.common.configuration.ActiveMqConfiguration;
import hr.mladenc.common.configuration.PropertiesConfiguration;
import hr.mladenc.common.configuration.RabbitMqConfiguration;
import hr.mladenc.common.constants.Constants;
import hr.mladenc.configuration.AmqpListenerConfiguration;
import hr.mladenc.configuration.JmsListenerConfiguration;
import hr.mladenc.configuration.ProcessorConfiguration;

import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

/**
 * Standolone implementation of processor
 *
 * @author mladenc
 *
 */
public class MessageProcessorRunner {

    /**
     * @param args
     */
    public static void main(final String[] args) {
        final GenericApplicationContext context = new GenericApplicationContext();
        context.getEnvironment().setActiveProfiles(MessageProcessorRunner.addActiveProfiles());

        final AnnotatedBeanDefinitionReader reader = new AnnotatedBeanDefinitionReader(context);
        reader.register(PropertiesConfiguration.class, RabbitMqConfiguration.class, ActiveMqConfiguration.class,
                ProcessorConfiguration.class, AmqpListenerConfiguration.class, JmsListenerConfiguration.class);

        context.refresh();
    }

    /**
     * @return
     */
    private static String[] addActiveProfiles() {
        // final String[] ret = { Constants.SPRING_AMQP_PROFILE, Constants.SPRING_AMQP_PROCESSOR };
        final String[] ret = { Constants.SPRING_JMS_PROFILE };

        return ret;
    }

}
