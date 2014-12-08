/**
 *
 */
package hr.mladenc.processor;

import hr.mladenc.model.message.AbstractMessage;

/**
 * @author mladenc
 *
 */
public interface MessageProcessor {

    public void process(AbstractMessage message);

}
