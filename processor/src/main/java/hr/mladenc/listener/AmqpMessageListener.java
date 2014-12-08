/**
 *
 */
package hr.mladenc.listener;

import hr.mladenc.model.message.MessageFactory;
import hr.mladenc.processor.MessageProcessor;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @author mladenc
 *
 */
@Component
@Profile("amqp")
public class AmqpMessageListener implements MessageListener {
    private static final Logger log = LoggerFactory.getLogger(AmqpMessageListener.class);

    @Resource(name = "${processor.name}")
    private MessageProcessor processor;

    private MessageFactory factor = new MessageFactory();

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.amqp.core.MessageListener#onMessage(org.springframework.amqp.core.Message)
     */
    @Override
    public void onMessage(final Message message) {
        final String m = new String(message.getBody());
        AmqpMessageListener.log.debug("Listener got {}", m);

        this.processor.process(this.factor.getMessage(m));
    }

}
