/**
 *
 */
package hr.mladenc.model.message;

import hr.mladenc.model.constants.ValidationConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author mladenc
 *
 */
public class MessageValidator {

    private static final Logger log = LoggerFactory.getLogger(MessageValidator.class);
    final Pattern protocolVersionPattern = Pattern.compile("\\d{2}\\.\\d\\.\\d");

    public List<ValidationConstants> validate(final String message) {
        final MessageFactory mf = new MessageFactory();
        final AbstractMessage incomingMessage = mf.getMessage(message);
        final ArrayList<ValidationConstants> ret = new ArrayList<ValidationConstants>();

        if (incomingMessage != null) {

            if (incomingMessage.getMessageId() == null) {
                MessageValidator.log.info("messageId is mandatory");
                ret.add(ValidationConstants.MESSAGE_ID_MANDATORY);
            } else if (incomingMessage.getMessageId() < 1) {
                MessageValidator.log.info("messageId must be positive integer number");
                ret.add(ValidationConstants.MESSAGE_ID_NOT_POSITIVE);
            }
            if (incomingMessage.getTimestamp() == null) {
                MessageValidator.log.info("timestamp is mandatory");
                ret.add(ValidationConstants.TIMESTAMP_MANDATORY);
            } else if (incomingMessage.getTimestamp().signum() < 1) {
                MessageValidator.log.info("timestamp must be positive integer number");
                ret.add(ValidationConstants.TIMESTAMP_NOT_POSITIVE);
            }
            if (incomingMessage.getProtocolVersion() == null) {
                MessageValidator.log.info("protocolVersion is mandatory");
                ret.add(ValidationConstants.PROTOCOL_VERSION_MANDATORY);
            } else {
                final Matcher matcher = this.protocolVersionPattern.matcher(incomingMessage.getProtocolVersion());
                if (!matcher.matches()) {
                    MessageValidator.log
                            .info("protocolVersion has format ##.#.# where # stays for one numeric character");
                    ret.add(ValidationConstants.PROTOCOL_VERSION_INVALID_FORMAT);
                }
            }

            if (ret.isEmpty()) {
                ret.add(ValidationConstants.VALIDATION_OK);
            }
        } else {
            ret.add(ValidationConstants.NOT_MESSAGE_OBJECT);
        }

        return ret;
    }

}
