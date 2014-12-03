/**
 *
 */
package hr.mladenc.model.message;

import hr.mladenc.model.message.v100.MessageV100;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author mladenc
 *
 */
public class MessageFactory {
    private static final Logger log = LoggerFactory.getLogger(MessageFactory.class);

    public AbstractMessage getMessage(final String message) {
        final ObjectMapper mapper = new ObjectMapper();
        AbstractMessage ret = null;

        try {
            ret = mapper.readValue(message, MessageV100.class);
        } catch (final IOException e) {
            MessageFactory.log.error("Error reading stream. Error description: {}", e.getLocalizedMessage());
        }

        if (ret != null) {
            return ret;
        }

        MessageFactory.log.warn("Message {} could not be deserialized", message);
        return null;
    }
}
