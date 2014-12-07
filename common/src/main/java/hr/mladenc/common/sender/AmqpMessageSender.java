/**
 *
 */
package hr.mladenc.common.sender;

import org.springframework.amqp.core.AmqpTemplate;

/**
 * @author mladenc
 *
 */
public class AmqpMessageSender implements MessageSender {

    private final AmqpTemplate template;

    public AmqpMessageSender(final AmqpTemplate template) {
        this.template = template;
    }

    /*
     * (non-Javadoc)
     * 
     * @see hr.mladenc.gateway.sender.MessageSender#send(java.lang.Object)
     */
    @Override
    public void send(final Object message) {
        this.template.convertAndSend(message);
    }

}
