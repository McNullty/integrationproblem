/**
 *
 */
package hr.mladenc.listener;

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

    @JmsListener(destination = "${queue.name}")
    public void process(final String data) {

        JmsMessageListener.log.debug("Listener got {}", data);

    }

}
