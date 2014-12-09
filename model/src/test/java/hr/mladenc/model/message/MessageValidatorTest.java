/**
 *
 */
package hr.mladenc.model.message;

import hr.mladenc.model.constants.ValidationConstants;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author mladenc
 *
 */
public class MessageValidatorTest {

    private MessageValidator validator;

    @Before
    public void initialize() {
        this.validator = new MessageValidator();
    }

    @Test
    public void testMessageIdIsMandatory() {
        final String message = "{\"timestamp\":123456789, \"protocolVersion\":\"1.0.0\", \"messageData\":{\"mMX\":212234, \"mPermGen\":552232}}";

        final List<ValidationConstants> ret = this.validator.validate(message);
        Assert.assertTrue(ret.contains(ValidationConstants.MESSAGE_ID_MANDATORY));
    }

    @Test
    public void testMessageIdShoulBePositive() {
        final String message = "{\"messageId\":0, \"timestamp\":123456789, \"protocolVersion\":\"1.0.0\", \"messageData\":{\"mMX\":212234, \"mPermGen\":552232}}";

        final List<ValidationConstants> ret = this.validator.validate(message);
        Assert.assertTrue(ret.contains(ValidationConstants.MESSAGE_ID_NOT_POSITIVE));
    }

    @Test
    public void testTimestampIsMandatory() {
        final String message = "{\"messageId\":202, \"protocolVersion\":\"1.0.0\", \"messageData\":{\"mMX\":212234, \"mPermGen\":552232}}";

        final List<ValidationConstants> ret = this.validator.validate(message);
        Assert.assertTrue(ret.contains(ValidationConstants.TIMESTAMP_MANDATORY));
    }

    @Test
    public void testTimestampShoulBePositive() {
        final String message = "{\"messageId\":202, \"timestamp\":0, \"protocolVersion\":\"1.0.0\", \"messageData\":{\"mMX\":212234, \"mPermGen\":552232}}";

        final List<ValidationConstants> ret = this.validator.validate(message);
        Assert.assertTrue(ret.contains(ValidationConstants.TIMESTAMP_NOT_POSITIVE));
    }

    @Test
    public void testSuccessfulParsingMessageV100() {
        final String message = "{\"messageId\":202, \"timestamp\":123456789, \"protocolVersion\":\"01.0.0\", \"messageData\":{\"mMX\":212234, \"mPermGen\":552232}}";

        final List<ValidationConstants> ret = this.validator.validate(message);
        Assert.assertTrue(ret.contains(ValidationConstants.VALIDATION_OK));
    }

    @Test
    public void testProtocolVersionIsMandatory() {
        final String message = "{\"messageId\":202, \"timestamp\":123456789, \"messageData\":{\"mMX\":212234, \"mPermGen\":552232}}";

        final List<ValidationConstants> ret = this.validator.validate(message);
        Assert.assertTrue(ret.contains(ValidationConstants.PROTOCOL_VERSION_MANDATORY));
    }

    @Test
    public void testProtocolVersionFormat() {
        final String message = "{\"messageId\":202, \"timestamp\":123456789, \"protocolVersion\":\"1.0.0\", \"messageData\":{\"mMX\":212234, \"mPermGen\":552232}}";

        final List<ValidationConstants> ret = this.validator.validate(message);
        Assert.assertTrue(ret.contains(ValidationConstants.PROTOCOL_VERSION_INVALID_FORMAT));
    }

    @Test
    public void testSuccessfulParsingMessageV101() {
        final String message = "{\"messageId\":367, \"timestamp\":124556789, \"protocolVersion\":\"01.0.1\", \"messageData\":{\"mMX\":212234, \"mPermGen\":552232, \"mOldGen\":2567000}}";

        final List<ValidationConstants> ret = this.validator.validate(message);
        Assert.assertTrue(ret.contains(ValidationConstants.VALIDATION_OK));
    }

    @Test
    public void testSuccessfulParsingMessageV200() {
        final String message = "{\"messageId\":915, \"timestamp\":125656789, \"protocolVersion\":\"02.0.0\", \"payload\":{\"mMX\":212234, \"mPermGen\":552232, \"mOldGen\":2567000, \"mYoungGen\":145600}}";

        final List<ValidationConstants> ret = this.validator.validate(message);
        Assert.assertTrue(ret.contains(ValidationConstants.VALIDATION_OK));
    }
}
