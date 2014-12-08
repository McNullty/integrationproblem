/**
 *
 */
package hr.mladenc.listener;

import javax.jms.MessageListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Component;

/**
 * @author mladenc
 *
 */
@Component
public class WebProcessor implements MessageListener, org.springframework.amqp.core.MessageListener {
    private static final Logger log = LoggerFactory.getLogger(WebProcessor.class);

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.amqp.core.MessageListener#onMessage(org.springframework.amqp.core.Message)
     */
    @Override
    public void onMessage(final Message message) {
        WebProcessor.log.debug(message.toString());
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.jms.MessageListener#onMessage(javax.jms.Message)
     */
    @Override
    public void onMessage(final javax.jms.Message message) {
        WebProcessor.log.debug(message.toString());
    }

}
