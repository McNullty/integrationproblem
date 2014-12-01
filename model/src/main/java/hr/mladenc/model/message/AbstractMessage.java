/**
 *
 */
package hr.mladenc.model.message;

import java.math.BigInteger;

/**
 *
 * @author mladenc
 *
 */
public abstract class AbstractMessage {

    private Integer messageId;

    private BigInteger timestamp;

    private String protocolVersion;

    /**
     * @return the messageId
     */
    public Integer getMessageId() {
        return this.messageId;
    }

    /**
     * @param messageId
     *            the messageId to set
     */
    public void setMessageId(final Integer messageId) {
        this.messageId = messageId;
    }

    /**
     * @return the timestamp
     */
    public BigInteger getTimestamp() {
        return this.timestamp;
    }

    /**
     * @param timestamp
     *            the timestamp to set
     */
    public void setTimestamp(final BigInteger timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * @return the protocolVersion
     */
    public String getProtocolVersion() {
        return this.protocolVersion;
    }

    /**
     * @param protocolVersion
     *            the protocolVersion to set
     */
    public void setProtocolVersion(final String protocolVersion) {
        this.protocolVersion = protocolVersion;
    }
}
