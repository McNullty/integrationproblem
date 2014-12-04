/**
 *
 */
package hr.mladenc.model.message.v101;

import java.math.BigInteger;

/**
 * @author mladenc
 *
 */
public class MessageDataV101 {

    private BigInteger mMX;

    private BigInteger mPermGen;

    private BigInteger mOldGen;

    /**
     * @return the mMX
     */
    public BigInteger getmMX() {
        return this.mMX;
    }

    /**
     * @param mMX
     *            the mMX to set
     */
    public void setmMX(final BigInteger mMX) {
        this.mMX = mMX;
    }

    /**
     * @return the mPermGen
     */
    public BigInteger getmPermGen() {
        return this.mPermGen;
    }

    /**
     * @param mPermGen
     *            the mPermGen to set
     */
    public void setmPermGen(final BigInteger mPermGen) {
        this.mPermGen = mPermGen;
    }

    /**
     * @return the mOldGen
     */
    public BigInteger getmOldGen() {
        return this.mOldGen;
    }

    /**
     * @param mOldGen
     *            the mOldGen to set
     */
    public void setmOldGen(final BigInteger mOldGen) {
        this.mOldGen = mOldGen;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "MessageDataV101 [mMX=" + this.mMX + ", mPermGen=" + this.mPermGen + ", mOldGen=" + this.mOldGen + "]";
    }
}
