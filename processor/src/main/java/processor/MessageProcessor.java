/**
 *
 */
package processor;

import hr.mladenc.common.configuration.ActiveMqConfiguration;
import hr.mladenc.common.configuration.PropertiesConfiguration;
import hr.mladenc.common.configuration.RabbitMqConfiguration;
import hr.mladenc.common.constants.Constants;
import hr.mladenc.common.reciver.MessageReceiver;

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
public class MessageProcessor {
    private static final Logger log = LoggerFactory.getLogger(MessageProcessor.class);

    /**
     * @param args
     */
    public static void main(final String[] args) {
        final GenericApplicationContext context = new GenericApplicationContext();
        context.getEnvironment().setActiveProfiles(MessageProcessor.addActiveProfiles());

        final AnnotatedBeanDefinitionReader reader = new AnnotatedBeanDefinitionReader(context);
        reader.register(PropertiesConfiguration.class, RabbitMqConfiguration.class, ActiveMqConfiguration.class);

        context.refresh();

        final MessageReceiver receiver = context.getBean(MessageReceiver.class);

        while (true) {
            final String message = receiver.receive();

            MessageProcessor.log.debug("Got message: {}", message);
        }
    }

    /**
     * @return
     */
    private static String[] addActiveProfiles() {
        // final String[] ret = { Constants.SPRING_AMQP_PROFILE, Constants.SPRING_AMQP_PROCESSOR };
        final String[] ret = { Constants.SPRING_JMS_PROFILE, Constants.SPRING_JMS_PROCESSOR };

        return ret;
    }

}
