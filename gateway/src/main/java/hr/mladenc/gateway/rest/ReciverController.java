/**
 *
 */
package hr.mladenc.gateway.rest;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controler that accepts JSON messages
 *
 * @author mladenc
 *
 */
@RestController
public class ReciverController {

    final static Logger log = LoggerFactory.getLogger(ReciverController.class);

    @Inject
    private AmqpTemplate template;

    @RequestMapping(value = "/recive", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> recive(@RequestBody final String message) throws Exception {
        ReciverController.log.debug("Got message: {}", message);

        if (isValid(message)) {
            // TODO: Parametrizirati
            this.template.convertAndSend("messageGatewayQueue", message);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
    }

    /**
     * Checks revived messages against JSON schemas
     *
     * @param message
     * @return
     */
    private boolean isValid(final String message) {
        // TODO Auto-generated method stub
        return true;
    }
}
