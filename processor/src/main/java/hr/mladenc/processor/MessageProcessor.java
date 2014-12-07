/**
 *
 */
package hr.mladenc.processor;


/**
 * @author mladenc
 *
 */
public interface MessageProcessor {

    public void process(String queueName);
}
