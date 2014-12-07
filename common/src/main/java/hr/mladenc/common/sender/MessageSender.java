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

}
