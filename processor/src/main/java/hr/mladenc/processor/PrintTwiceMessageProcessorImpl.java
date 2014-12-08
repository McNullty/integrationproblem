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
@Component(value = "PrintTwiceMessageProcessorImpl")
public class PrintTwiceMessageProcessorImpl implements MessageProcessor {

    /*
     * (non-Javadoc)
     * 
     * @see hr.mladenc.processor.MessageProcessor#process(java.lang.String)
     */
    @Override
    public void process(final AbstractMessage m) {
        if (m instanceof MessageV100) {
            System.out.println("Processing message version 1.0.0: " + m.toString());
            System.out.println("Processing message version 1.0.0: " + m.toString());
        } else if (m instanceof MessageV101) {
            System.out.println("Processing message version 1.0.1: " + m.toString());
            System.out.println("Processing message version 1.0.1: " + m.toString());
        } else if (m instanceof MessageV200) {
            System.out.println("Processing message version 2.0.0: " + m.toString());
            System.out.println("Processing message version 2.0.0: " + m.toString());
        }
    }

}
