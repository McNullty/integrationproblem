/**
 *
 */
package hr.mladenc.gateway.rest;

import hr.mladenc.common.sender.MessageSender;
import hr.mladenc.model.constants.ValidationConstants;
import hr.mladenc.model.message.MessageValidator;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller that accepts JSON messages
 *
 * @author mladenc
 *
 */
@RestController
public class ReciverController {

    final static Logger log = LoggerFactory.getLogger(ReciverController.class);

    // @Inject
    // private Environment env;

    @Inject
    private MessageSender sender;

    @Inject
    private MessageValidator validator;

    @RequestMapping(value = "/recive", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> recive(@RequestBody final String message) throws Exception {
        ReciverController.log.debug("Got message: {}", message);

        final List<ValidationConstants> validationResults = this.validator.validate(message);
        if (validationResults.contains(ValidationConstants.VALIDATION_OK)) {
            this.sender.send(message);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            final String validationMessage = getValidationMessage(validationResults);

            ReciverController.log.error(validationMessage);

            return new ResponseEntity<String>(validationMessage, HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * @param validationResults
     * @return
     */
    private String getValidationMessage(final List<ValidationConstants> validationResults) {
        final StringBuilder sb = new StringBuilder();

        if (validationResults.contains(ValidationConstants.NOT_MESSAGE_OBJECT)) {
            sb.append("Message couldn't be deserialized. ");
        }

        if (validationResults.contains(ValidationConstants.MESSAGE_ID_MANDATORY)) {
            sb.append("MessageId shouln't be null. ");
        }
        if (validationResults.contains(ValidationConstants.MESSAGE_ID_NOT_POSITIVE)) {
            sb.append("MessageId must be positive integer. ");
        }

        if (validationResults.contains(ValidationConstants.TIMESTAMP_MANDATORY)) {
            sb.append("Timestamp shouln't be null. ");
        }
        if (validationResults.contains(ValidationConstants.TIMESTAMP_NOT_POSITIVE)) {
            sb.append("Timestamp must be positive integer. ");
        }

        if (validationResults.contains(ValidationConstants.PROTOCOL_VERSION_MANDATORY)) {
            sb.append("Protocol version shouln't be null. ");
        }
        if (validationResults.contains(ValidationConstants.PROTOCOL_VERSION_INVALID_FORMAT)) {
            sb.append("Protocol version must fave format  ##.#.# where # stays for one numeric character. ");
        }
        return sb.toString();
    }
}
