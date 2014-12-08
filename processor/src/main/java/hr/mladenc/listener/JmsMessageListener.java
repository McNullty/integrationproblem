/**
 *
 */
package hr.mladenc.listener;

import hr.mladenc.model.message.MessageFactory;
import hr.mladenc.processor.MessageProcessor;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author mladenc
 *
 */
@Component
@Profile("jms")
public class JmsMessageListener {

    private static final Logger log = LoggerFactory.getLogger(JmsMessageListener.class);

    @Resource(name = "${processor.name}")
    private MessageProcessor processor;

    private MessageFactory factor = new MessageFactory();

    @JmsListener(destination = "${queue.name}")
    public void process(final String data) {

        JmsMessageListener.log.debug("Listener got {}", data);

        this.processor.process(this.factor.getMessage(data));
    }

}
