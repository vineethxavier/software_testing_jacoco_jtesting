package DTTS;

public class ComputeSimulationState {

	// Initial element in the following tables is ignored in the code to make the Region number correspond to the index number of the array
	// This eliminates ZBN issues
	static double price_rate[]= {0.0,0.001,0.00125,0.0015,0.0}, buy_rate[]={0.0,0.01,0.015,0.01,0.0};
	static int volume[] = {0,25000,50000,150000,0};
	static String STRP_state_table [] = {"","SR1","SR2","SR3","End"};

	static int get_STRP_region (int TTL) {
	
		// This method returns the value of the STRP region for use by the above tables
		int STRP_region;
		if (TTL >=20)
			STRP_region=1;
		else 
			if (TTL >=5)
				STRP_region=2;
			else
				if (TTL>0) 
					STRP_region=3;
				else
					STRP_region=4;
		return STRP_region;		
	}
	
	public void compute_state (Data data, Alerts alerts) {
	
		// decrement remaining time
		data.setTTL(data.getTTL()-1);

		// set STRP, Price and Volume based on remaining time
		data.setSTRP_state(STRP_state_table [get_STRP_region(data.getTTL())]);
		data.setPrice(data.getPrice()*(1.0+price_rate[get_STRP_region(data.getTTL())]));
		data.setVolume(volume[get_STRP_region(data.getTTL())]);

		// determine if the user is buying stock and update balance
		if (data.getFUNDBtnState()=="N" & data.getBUYBtnState()=="T" & !alerts.isEfund_purchase_latch())
			data.setBalance(data.getBalance() - data.getPrice()*data.getVolume()*buy_rate[get_STRP_region(data.getTTL())]);
	
		// calculate alerts - according to the requirements these are performed after financial calculations
		alerts.setBALN(data.getBalance() < 0.0);
		alerts.setBAL10((data.getBalance() < 0.1*data.getInitial_balance()) & data.getBalance() >= 0.0);
		if (data.getTTL() < 5 & data.getFUNDBtnState()=="N" & alerts.getEfund_persistence_count()==3) {
			alerts.setEFUND(true);
			alerts.setEfund_purchase_latch(true);
			data.setFUNDBtnState("F");
//			data.setfundBtnFLatch(true);
		}
		
//		this part keeps the EFUND alert active for 3 seconds - Efund-persistence_count is the counter used to do this
		if (alerts.isEfund_purchase_latch() & alerts.getEfund_persistence_count()>0) {
			alerts.setEfund_persistence_count(alerts.getEfund_persistence_count()-1);
			alerts.setEFUND(true);
		}
		else
			alerts.setEFUND(false);
		
		alerts.setNFUND(data.getTTL()<20 & data.getFUNDBtnState()=="N" & !alerts.isEfund_purchase_latch());
		alerts.setNTBUY((data.getTTL()>0) & ((data.getBUYBtnState()=="H"|data.getFUNDBtnState()=="F" | alerts.isEfund_purchase_latch())));
		if (data.getTTL()==0) {
			if (data.getBalance() < .1*data.getInitial_balance() & data.getBalance() > 0) {
				alerts.setPASS(true);
				alerts.setFAIL(false);
				}
			else {
				alerts.setPASS(false);
				alerts.setFAIL(true);	
			}
		}
	}
}