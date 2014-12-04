/**
 *
 */
package hr.mladenc.model.message.v200;

import hr.mladenc.model.message.AbstractMessage;

/**
 * @author mladenc
 *
 */
public class MessageV200 extends AbstractMessage {
    private Payload payload;

    /**
     * @return the payload
     */
    public Payload getPayload() {
        return this.payload;
    }

    /**
     * @param payload
     *            the payload to set
     */
    public void setPayload(final Payload payload) {
        this.payload = payload;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "MessageV200 [payload=" + this.payload + ", getMessageId()=" + getMessageId() + ", getTimestamp()="
                + getTimestamp() + ", getProtocolVersion()=" + getProtocolVersion() + "]";
    }

}
