/**
 *
 */
package hr.mladenc.model.message;

import hr.mladenc.model.message.v100.MessageV100;
import hr.mladenc.model.message.v101.MessageV101;
import hr.mladenc.model.message.v200.MessageV200;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author mladenc
 *
 */
public class MessageFactory {
    private static final Logger log = LoggerFactory.getLogger(MessageFactory.class);

    public AbstractMessage getMessage(final String message) {

        AbstractMessage ret = null;

        ret = deserialize(message, MessageV100.class);

        if (ret == null) {
            ret = deserialize(message, MessageV101.class);
        }

        if (ret == null) {
            ret = deserialize(message, MessageV200.class);
        }

        if (ret != null) {
            return ret;
        }

        MessageFactory.log.warn("Message {} could not be deserialized", message);
        return null;
    }

    private <T extends AbstractMessage> AbstractMessage deserialize(final String message, final Class<T> valueType) {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES);

        AbstractMessage ret = null;

        try {
            ret = mapper.readValue(message, valueType);
        } catch (final IOException e) {
            MessageFactory.log.info("Could not deserialize as class {}", valueType.getName());
        }

        return ret;
    }
}
