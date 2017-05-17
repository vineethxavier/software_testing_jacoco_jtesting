package DTTS;

public class Alerts {

	private boolean NTBUY, BALN, NFUND, FAIL, EFUND, BAL10, PASS;
	private int efund_persistence_count; 
	private boolean efund_purchase_latch;

	public boolean isNTBUY() {
		return NTBUY;
	}
	public void setNTBUY(boolean nTBUY) {
		NTBUY = nTBUY;
	}
	public boolean isBALN() {
		return BALN;
	}
	public void setBALN(boolean bALN) {
		BALN = bALN;
	}
	public boolean isNFUND() {
		return NFUND;
	}
	public void setNFUND(boolean nFUND) {
		NFUND = nFUND;
	}
	public boolean isFAIL() {
		return FAIL;
	}
	public void setFAIL(boolean fAIL) {
		FAIL = fAIL;
	}
	public boolean isBAL10() {
		return BAL10;
	}
	public void setBAL10(boolean bAL10) {
		BAL10 = bAL10;
	}
	public boolean isPASS() {
		return PASS;
	}
	public void setPASS(boolean pASS) {
		PASS = pASS;
	}
	public int getEfund_persistence_count() {
		return efund_persistence_count;
	}
	public void setEfund_persistence_count(int efund_persistence_count) {
		this.efund_persistence_count = efund_persistence_count;
	}
	public boolean isEfund_purchase_latch() {
		return efund_purchase_latch;
	}
	public void setEfund_purchase_latch(boolean efund_purchase_latch) {
		this.efund_purchase_latch = efund_purchase_latch;
	}
	public boolean isEFUND() {
		return EFUND;
	}
	public void setEFUND(boolean eFUND) {
		EFUND = eFUND;
	}
}
