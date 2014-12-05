/**
 *
 */
package hr.mladenc.gateway.rest;

import hr.mladenc.gateway.sender.MessageSender;
import hr.mladenc.model.message.MessageValidator;

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

        if (this.validator.validate(message)) {
            this.sender.send(message);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            ReciverController.log.error("Error validating message {}", message);

            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
    }
}
