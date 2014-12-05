/**
 *
 */
package hr.mladenc.gateway.sender;

import org.springframework.jms.core.JmsMessagingTemplate;

/**
 * @author mladenc
 *
 */
public class JmsMessageSender implements MessageSender {

    private final JmsMessagingTemplate jmsTemplate;

    /**
     * @param jmsTemplate
     */
    public JmsMessageSender(final JmsMessagingTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    /*
     * (non-Javadoc)
     *
     * @see hr.mladenc.gateway.sender.MessageSender#send(java.lang.Object)
     */
    @Override
    public void send(final Object message) {
        this.jmsTemplate.convertAndSend(message);
    }

}
