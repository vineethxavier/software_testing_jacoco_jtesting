package DTTS;

public class Data {

	private double price,balance,initial_balance=606500.0;
	private int TTL,Volume;
	private String TICK,STRP_state,BUYBtnState,FUNDBtnState;
	private boolean printdata,fundBtnFLatch;

//  ***DEBUG - REMOVE - assuming only one button press per iteration
	public enum button_pressed {NULL,FUNDF,FUNDN,BUYT,BUYH};
	private button_pressed btnPressed;
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getTTL() {
		return TTL;
	}

	public void setTTL(int tTL) {
		TTL = tTL;
	}

	public int getVolume() {
		return Volume;
	}

	public void setVolume(int volume) {
		Volume = volume;
	}

	public String getTICK() {
		return TICK;
	}

	public void setTICK(String tICK) {
		TICK = tICK;
	}

	public String getSTRP_state() {
		return STRP_state;
	}

	public void setSTRP_state(String sTRP_state) {
		STRP_state = sTRP_state;
	}

	public String getBUYBtnState() {
		return BUYBtnState;
	}

	public void setBUYBtnState(String bUYBtnState) {
		BUYBtnState = bUYBtnState;
	}

	public String getFUNDBtnState() {
		return FUNDBtnState;
	}

	public void setFUNDBtnState(String fUNDBtnState) {
		FUNDBtnState = fUNDBtnState;
	}

	public double getInitial_balance() {
		return initial_balance;
	}

	public void setInitial_balance(double initial_balance) {
		this.initial_balance = initial_balance;
	}

	public boolean isPrintdata() {
		return printdata;
	}

	public void setPrintdata(boolean printdata) {
		this.printdata = printdata;
	}

	public boolean isfundBtnFLatch() {
		return fundBtnFLatch;
	}

	public void setfundBtnFLatch(boolean fundBtnFLatch) {
		this.fundBtnFLatch = fundBtnFLatch;
	}

//  ***DEBUG - REMOVE
	public button_pressed getBtnPressed() {
		return btnPressed;
	}

//  ***DEBUG - REMOVE
	public void setBtnPressed(button_pressed btnPressed) {
		this.btnPressed = btnPressed;
	}
			
}
