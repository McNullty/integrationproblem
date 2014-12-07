/**
 *
 */
package hr.mladenc.model.message;

import hr.mladenc.model.message.v100.MessageV100;
import hr.mladenc.model.message.v101.MessageV101;
import hr.mladenc.model.message.v200.MessageV200;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author mladenc
 *
 */
public class MessageFactoryTest {

    private MessageFactory factory;

    @Before
    public void initialize() {
        this.factory = new MessageFactory();
    }

    @Test
    public void testVesrsion100() {
        final String message = "{\"messageId\":202, \"timestamp\":123456789, \"protocolVersion\":\"01.0.0\", \"messageData\":{\"mMX\":212234, \"mPermGen\":552232}}";

        final AbstractMessage am = this.factory.getMessage(message);
        Assert.assertTrue(am instanceof MessageV100);
    }

    @Test
    public void testVesrsion101() {
        final String message = "{\"messageId\":367, \"timestamp\":124556789, \"protocolVersion\":\"01.0.1\", \"messageData\":{\"mMX\":212234, \"mPermGen\":552232, \"mOldGen\":2567000}}";

        final AbstractMessage am = this.factory.getMessage(message);
        Assert.assertTrue(am instanceof MessageV101);
    }

    @Test
    public void testVesrsion200() {
        final String message = "{\"messageId\":915, \"timestamp\":125656789, \"protocolVersion\":\"02.0.0\", \"payload\":{\"mMX\":212234, \"mPermGen\":552232, \"mOldGen\":2567000, \"mYoungGen\":145600}}";

        final AbstractMessage am = this.factory.getMessage(message);
        Assert.assertTrue(am instanceof MessageV200);
    }

}
