/**
 *
 */
package hr.mladenc.model.message;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author mladenc
 *
 */
public class Validator {

    private static final Logger log = LoggerFactory.getLogger(Validator.class);

    public Boolean validate(final String message) {
        final MessageFactory mf = new MessageFactory();
        final AbstractMessage incomingMessage = mf.getMessage(message);

        if (incomingMessage != null) {
            if ((incomingMessage.getMessageId() == null) || (incomingMessage.getTimestamp() == null)
                    || (incomingMessage.getProtocolVersion() == null)) {
                Validator.log.info("messageId, timestamp and protocolVersion are mandatory");
                return false;
            }

            if ((incomingMessage.getMessageId() < 1) || (incomingMessage.getTimestamp().signum() < 1)) {
                Validator.log.info("messageId and timestamp are positive integer numbers");
                return false;
            }

            final Pattern protocolVersionPattern = Pattern.compile("\\d{2}\\.\\d\\.\\d");
            final Matcher matcher = protocolVersionPattern.matcher(incomingMessage.getProtocolVersion());
            if (!matcher.matches()) {
                Validator.log.info("protocolVersion has format ##.#.# where # stays for one numeric character");
                return false;
            }

            return true;
        } else {
            return false;
        }
    }

}
