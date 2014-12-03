/**
 *
 */
package hr.mladenc.model.message;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author mladenc
 *
 */
public class ValidatorTest {

    private Validator validator;

    @Before
    public void initialize() {
        this.validator = new Validator();
    }

    @Test
    public void testMessageIdIsMandatory() {
        final String message = "{\"timestamp\":123456789, \"protocolVersion\":\"1.0.0\", \"messageData\":{\"mMX\":212234, \"mPermGen\":552232}}";

        Assert.assertFalse(this.validator.validate(message));
    }

    @Test
    public void testMessageShoulBePositive() {
        final String message = "{\"messageId\":0, \"timestamp\":123456789, \"protocolVersion\":\"1.0.0\", \"messageData\":{\"mMX\":212234, \"mPermGen\":552232}}";

        Assert.assertFalse(this.validator.validate(message));
    }

    @Test
    public void testTimestampIsMandatory() {
        final String message = "{\"messageId\":202, \"protocolVersion\":\"1.0.0\", \"messageData\":{\"mMX\":212234, \"mPermGen\":552232}}";

        Assert.assertFalse(this.validator.validate(message));
    }

    @Test
    public void testTimestampShoulBePositive() {
        final String message = "{\"messageId\":202, \"timestamp\":0, \"protocolVersion\":\"1.0.0\", \"messageData\":{\"mMX\":212234, \"mPermGen\":552232}}";

        Assert.assertFalse(this.validator.validate(message));
    }

    @Test
    public void testSuccessfulParsingMessageV100() {
        final String message = "{\"messageId\":202, \"timestamp\":123456789, \"protocolVersion\":\"01.0.0\", \"messageData\":{\"mMX\":212234, \"mPermGen\":552232}}";

        Assert.assertTrue(this.validator.validate(message));
    }

    @Test
    public void testProtocolVersionIsMandatory() {
        final String message = "{\"messageId\":202, \"timestamp\":123456789, \"messageData\":{\"mMX\":212234, \"mPermGen\":552232}}";

        Assert.assertFalse(this.validator.validate(message));
    }

    @Test
    public void testProtocolVersionFormat() {
        final String message = "{\"messageId\":202, \"timestamp\":123456789, \"protocolVersion\":\"1.0.0\", \"messageData\":{\"mMX\":212234, \"mPermGen\":552232}}";

        Assert.assertFalse(this.validator.validate(message));
    }

    @Test
    public void testSuccessfulParsingMessageV101() {
        final String message = "{\"messageId\":367, \"timestamp\":124556789, \"protocolVersion\":\"1.0.1\", \"messageData\":{\"mMX\":212234, \"mPermGen\":552232, \"mOldGen\":2567000}}";

        Assert.assertTrue(this.validator.validate(message));
    }
}
