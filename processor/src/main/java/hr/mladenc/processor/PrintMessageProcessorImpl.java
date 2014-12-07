/**
 *
 */
package hr.mladenc.processor;

import hr.mladenc.common.reciver.MessageReceiver;
import hr.mladenc.model.message.AbstractMessage;
import hr.mladenc.model.message.MessageFactory;
import hr.mladenc.model.message.v100.MessageV100;
import hr.mladenc.model.message.v101.MessageV101;
import hr.mladenc.model.message.v200.MessageV200;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author mladenc
 *
 */
@Component(value = "PrintMessageProcessorImpl")
public class PrintMessageProcessorImpl implements MessageProcessor {

    private static final Logger log = LoggerFactory.getLogger(PrintMessageProcessorImpl.class);

    @Inject
    private MessageReceiver receiver;

    /*
     * (non-Javadoc)
     * 
     * @see hr.mladenc.processor.MessageProcessor#process(java.lang.String)
     */
    @Override
    public void process(final String queueName) {
        this.receiver.setQueue(queueName);
        final MessageFactory factory = new MessageFactory();

        while (true) {
            final String message = this.receiver.receive();

            if (message != null) {
                PrintMessageProcessorImpl.log.debug("Got message: {}", message);
                final AbstractMessage m = factory.getMessage(message);

                print(m);
            }
        }
    }

    /**
     * @param message
     */
    private void print(final AbstractMessage m) {
        if (m instanceof MessageV100) {
            System.out.println("Processing message version 1.0.0: " + m.toString());
        } else if (m instanceof MessageV101) {
            System.out.println("Processing message version 1.0.1: " + m.toString());
        } else if (m instanceof MessageV200) {
            System.out.println("Processing message version 2.0.0: " + m.toString());
        }
    }

    /**
     * @return the receiver
     */
    public MessageReceiver getReceiver() {
        return this.receiver;
    }

    /**
     * @param receiver
     *            the receiver to set
     */
    public void setReceiver(final MessageReceiver receiver) {
        this.receiver = receiver;
    }

}
