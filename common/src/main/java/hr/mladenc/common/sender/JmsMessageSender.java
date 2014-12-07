/**
 *
 */
package hr.mladenc.common.sender;

import org.springframework.jms.core.JmsMessagingTemplate;

/**
 * @author mladenc
 *
 */
public class JmsMessageSender implements MessageSender {

    private final JmsMessagingTemplate jmsTemplate;
    private String queueName;

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
        this.jmsTemplate.convertAndSend(this.queueName, message);
    }

    /*
     * (non-Javadoc)
     *
     * @see hr.mladenc.common.sender.MessageSender#setQueue(java.lang.String)
     */
    @Override
    public void setQueue(final String queueName) {
        this.queueName = queueName;
    }

}
