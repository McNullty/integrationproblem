/**
 *
 */
package hr.mladenc.model.message.v100;

import hr.mladenc.model.message.AbstractMessage;

/**
 * @author mladenc
 *
 */
public class MessageV100 extends AbstractMessage {

    private MessageDataV100 messageData;

    /**
     * @return the messageData
     */
    public MessageDataV100 getMessageData() {
        return this.messageData;
    }

    /**
     * @param messageData
     *            the messageData to set
     */
    public void setMessageData(final MessageDataV100 messageData) {
        this.messageData = messageData;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "MessageV100 [messageData=" + this.messageData + ", getMessageId()=" + getMessageId()
                + ", getTimestamp()=" + getTimestamp() + ", getProtocolVersion()=" + getProtocolVersion() + "]";
    }
}
