/**
 *
 */
package hr.mladenc.processor;

import hr.mladenc.model.message.AbstractMessage;
import hr.mladenc.model.message.v100.MessageV100;
import hr.mladenc.model.message.v101.MessageV101;
import hr.mladenc.model.message.v200.MessageV200;

import org.springframework.stereotype.Component;

/**
 * @author mladenc
 *
 */
@Component(value = "PrintMessageProcessorImpl")
public class PrintMessageProcessorImpl implements MessageProcessor {

    /*
     * (non-Javadoc)
     * 
     * @see hr.mladenc.processor.MessageProcessor#process(hr.mladenc.model.message.AbstractMessage)
     */
    @Override
    public void process(final AbstractMessage message) {
        if (message instanceof MessageV100) {
            System.out.println("Processing message version 1.0.0: " + message.toString());
        } else if (message instanceof MessageV101) {
            System.out.println("Processing message version 1.0.1: " + message.toString());
        } else if (message instanceof MessageV200) {
            System.out.println("Processing message version 2.0.0: " + message.toString());
        }
    }

}
