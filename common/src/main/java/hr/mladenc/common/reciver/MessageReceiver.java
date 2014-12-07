/**
 *
 */
package hr.mladenc.common.reciver;

/**
 * @author mladenc
 *
 */
public interface MessageReceiver {

    /**
     * Receive
     * 
     * @return
     */
    public String receive();

    /**
     * @param queueName
     */
    public void setQueue(String queueName);
}
