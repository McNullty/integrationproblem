/**
 *
 */
package hr.mladenc.model.message.v100;

import java.math.BigInteger;

/**
 * @author mladenc
 *
 */
public class MessageDataV100 {

    private BigInteger mMX;

    private BigInteger mPermGen;

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

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "MessageDataV100 [mMX=" + this.mMX + ", mPermGen=" + this.mPermGen + "]";
    }

}
