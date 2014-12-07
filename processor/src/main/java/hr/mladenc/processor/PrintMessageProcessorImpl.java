/**
 *
 */
package hr.mladenc.processor;

import hr.mladenc.common.reciver.MessageReceiver;

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

        while (true) {
            final String message = this.receiver.receive();

            if (message != null) {
                PrintMessageProcessorImpl.log.debug("Got message: {}", message);
            }
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
