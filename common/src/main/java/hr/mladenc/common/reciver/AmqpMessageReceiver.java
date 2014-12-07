/**
 *
 */
package hr.mladenc.common.reciver;

import org.springframework.amqp.core.AmqpTemplate;

/**
 * @author mladenc
 *
 */
public class AmqpMessageReceiver implements MessageReceiver {

    private final AmqpTemplate template;
    private String queueName;

    public AmqpMessageReceiver(final AmqpTemplate template) {
        this.template = template;
    }

    /*
     * (non-Javadoc)
     * 
     * @see hr.mladenc.common.reciver.MessageReceiver#receive()
     */
    @Override
    public String receive() {
        return (String) this.template.receiveAndConvert(this.queueName);
    }

    /*
     * (non-Javadoc)
     * 
     * @see hr.mladenc.common.reciver.MessageReceiver#setQueue(java.lang.String)
     */
    @Override
    public void setQueue(final String queueName) {
        this.queueName = queueName;
    }

}
