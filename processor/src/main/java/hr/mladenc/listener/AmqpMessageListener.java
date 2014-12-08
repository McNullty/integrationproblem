/**
 *
 */
package hr.mladenc.listener;

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

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.amqp.core.MessageListener#onMessage(org.springframework.amqp.core.Message)
     */
    @Override
    public void onMessage(final Message message) {
        final String m = new String(message.getBody());
        AmqpMessageListener.log.debug("Listener got {}", m);
    }

}
