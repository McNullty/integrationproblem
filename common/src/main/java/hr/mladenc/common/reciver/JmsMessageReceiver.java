/**
 *
 */
package hr.mladenc.common.reciver;

import org.springframework.jms.core.JmsMessagingTemplate;

/**
 * @author mladenc
 *
 */
public class JmsMessageReceiver implements MessageReceiver {

    private final JmsMessagingTemplate jmsTemplate;

    /**
     * @param jmsTemplate
     */
    public JmsMessageReceiver(final JmsMessagingTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    /*
     * (non-Javadoc)
     *
     * @see hr.mladenc.common.reciver.MessageReceiver#receive()
     */
    @Override
    public String receive() {
        return this.jmsTemplate.receiveAndConvert(String.class);
    }

}
