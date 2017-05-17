package DTTS;

public class Main 
{
        public Main()
        {
        }
    	private void initialize_data (Data data) {
    		data.setPrice(20.0);
    		data.setBalance(data.getInitial_balance());
    		data.setTTL(90);
    		data.setVolume(25000);
    		data.setSTRP_state("SR1");
    		data.setBUYBtnState("T");
    		data.setFUNDBtnState("N");
    		data.setTICK("UTA");
    		data.setPrintdata(true);
    		data.setfundBtnFLatch(false);
    	}
    	
    	private void initialize_alerts (Alerts alerts) {
    		alerts.setNTBUY(false);
    		alerts.setBALN(false);
    		alerts.setNFUND(false);
    		alerts.setFAIL(false);
    		alerts.setBAL10(false);
    		alerts.setPASS(false);
    		alerts.setEfund_persistence_count(3);
    		alerts.setEfund_purchase_latch(false);
    	}
    	

   public void run()
        {
        	Data data = new Data();
        	Alerts alerts = new Alerts();
    		ComputeSimulationState sim_state = new ComputeSimulationState();
            DTTSDisplay display = new DTTSDisplay(data,alerts);
            display.setVisible(false);
            initialize_data(data);
			initialize_alerts(alerts);
			while (data.getTTL()>0)
            {
    			sim_state.compute_state(data, alerts);
    			display.updateDisplay(data, alerts);
    			try 
                {
                    Thread.sleep(1000);                 //1000 milliseconds is one second.
                } catch(InterruptedException ex) 
                {
                    Thread.currentThread().interrupt();
                }
            } 
        }
        
         /**
	 * Launch the application.
	 */
	public static void main(String[] args) 
        {
			Main DTTS = new Main();            
            DTTS.run();
		
	}
}
