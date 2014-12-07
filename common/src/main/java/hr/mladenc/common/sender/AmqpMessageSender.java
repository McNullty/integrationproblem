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
    private String queueName;

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
        this.template.convertAndSend(this.queueName, message);
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
