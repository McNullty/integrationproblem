/**
 *
 */
package hr.mladenc.model.message.v101;

import hr.mladenc.model.message.AbstractMessage;

/**
 * @author mladenc
 *
 */
public class MessageV101 extends AbstractMessage {
    private MessageDataV101 messageData;

    /**
     * @return the messageData
     */
    public MessageDataV101 getMessageData() {
        return this.messageData;
    }

    /**
     * @param messageData
     *            the messageData to set
     */
    public void setMessageData(final MessageDataV101 messageData) {
        this.messageData = messageData;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "MessageV101 [messageData=" + this.messageData + ", getMessageId()=" + getMessageId()
                + ", getTimestamp()=" + getTimestamp() + ", getProtocolVersion()=" + getProtocolVersion() + "]";
    }

}
