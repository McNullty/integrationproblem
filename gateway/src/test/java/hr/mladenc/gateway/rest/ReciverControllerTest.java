/**
 *
 */
package hr.mladenc.gateway.rest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author mladenc
 *
 */
public class ReciverControllerTest {

    private ReciverController reciverController;

    @Before
    public void initialize() {
        this.reciverController = new ReciverController();
    }

    @Test
    public void testValidatingMessageVersion100() {
        final String message = "{\"messageId”=202, \"timestamp”=123456789, \"protocolVersion”=”1.0.0”, \"messageData”:{\"mMX”:212234, \"mPermGen”:552232}}";

        try {
            final ResponseEntity<?> response = this.reciverController.recive(message);
            Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        } catch (final Exception e) {
            Assert.fail("Message caused exception");
        }
    }

}
