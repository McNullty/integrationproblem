/**
 *
 */
package hr.mladenc.gateway.sender;

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

}
