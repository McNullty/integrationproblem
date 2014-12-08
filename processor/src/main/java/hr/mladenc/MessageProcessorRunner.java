/**
 *
 */
package hr.mladenc;

import hr.mladenc.common.configuration.ActiveMqConfiguration;
import hr.mladenc.common.configuration.PropertiesConfiguration;
import hr.mladenc.common.configuration.RabbitMqConfiguration;
import hr.mladenc.common.constants.Constants;
import hr.mladenc.configuration.AmqpListenerConfiguration;
import hr.mladenc.configuration.ProcessorConfiguration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

/**
 * Standolone implementation of processor
 *
 * @author mladenc
 *
 */
public class MessageProcessorRunner {
    private static final Logger log = LoggerFactory.getLogger(MessageProcessorRunner.class);

    /**
     * @param args
     */
    public static void main(final String[] args) {
        final GenericApplicationContext context = new GenericApplicationContext();
        context.getEnvironment().setActiveProfiles(MessageProcessorRunner.addActiveProfiles());

        final AnnotatedBeanDefinitionReader reader = new AnnotatedBeanDefinitionReader(context);
        reader.register(PropertiesConfiguration.class, RabbitMqConfiguration.class, ActiveMqConfiguration.class,
                ProcessorConfiguration.class, AmqpListenerConfiguration.class);

        context.refresh();

        // TODO: Provjeriti standalone verziju
    }

    /**
     * @return
     */
    private static String[] addActiveProfiles() {
        // final String[] ret = { Constants.SPRING_AMQP_PROFILE, Constants.SPRING_AMQP_PROCESSOR };
        final String[] ret = { Constants.SPRING_JMS_PROFILE, Constants.SPRING_JMS_PROCESSOR,
                Constants.SPRING_JMS_STANDALONE };
        // final String[] ret = { Constants.SPRING_JMS_PROFILE, Constants.SPRING_JMS_PROCESSOR,
        // Constants.SPRING_JMS_EMBEDDED };

        return ret;
    }

}
