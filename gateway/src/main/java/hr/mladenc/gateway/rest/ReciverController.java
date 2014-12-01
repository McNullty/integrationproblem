/**
 *
 */
package hr.mladenc.gateway.rest;

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
 * Controler that accepts JSON messages
 *
 * @author mladenc
 *
 */
@RestController
public class ReciverController {

    final static Logger log = LoggerFactory.getLogger(ReciverController.class);

    @RequestMapping(value = "/recive", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> greeting(@RequestBody final String message) throws Exception {
        ReciverController.log.debug("Got message: {}", message);

        return new ResponseEntity<String>(HttpStatus.OK);
    }
}