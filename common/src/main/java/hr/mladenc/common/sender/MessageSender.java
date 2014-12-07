/**
 *
 */
package hr.mladenc.common.sender;

/**
 * @author mladenc
 *
 */
public interface MessageSender {

    /**
     * Sends object to queue
     *
     * @param message
     */
    void send(Object message);

    /**
     * Sets queue for sending messages
     *
     * @param queueName
     */
    public void setQueue(String queueName);
}
