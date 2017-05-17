package DTTS;

import static org.junit.Assert.*;
import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.*;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(JUnitParamsRunner.class)
public class ComputeSimulationStateTest {
	
    @SuppressWarnings("unused")
    private static final Object[] data()	{
   
	return $(
			
			//Test Case 1
			$(1,60650,25,"H","F",false,4,0,25,60650,0,"End",false,false,false,false,false,false,4,true,false,"F"),
			//Test Case 2
			$(2,60650,25,"H","F",false,4,1,25.0375,60650,150000,"SR3",true,false,false,false,false,false,4,false,false,"F"),
			//Test Case 3
			$(5,60650,25,"H","F",false,4,4,25.0375,60650,150000,"SR3",true,false,false,false,false,false,4,false,false,"F"),
			//Test Case 4
			$(6,60650,25,"H","F",false,4,5,25.03125,60650,50000,"SR2",true,false,false,false,false,false,4,false,false,"F"),
			//Test Case 5
			$(21,60650,25,"H","N",true,4,20,25.025,60650,25000,"SR1",true,false,false,false,true,true,3,false,false,"N"),
    		//Test Case 6
			$(21,60650,25,"T","N",false,3,20,25.025,54393.75,25000,"SR1",false,false,true,false,false,false,3,false,false,"N"),
			//Test Case 7
			$(21,60650,25,"T","F",true,4,20,25.025,60650,25000,"SR1",true,false,false,false,true,true,3,false,false,"F"),
			//Test Case 8
			$(21,60650,25,"T","N",true,4,20,25.025,60650,25000,"SR1",true,false,false,false,true,true,3,false,false,"N"),
			//Test Case 9
			$(21,60650,25,"H","N",false,3,20,25.025,60650,25000,"SR1",true,false,false,false,false,false,3,false,false,"N"),
			//Test Case 10
			$(21,-0.01,25,"T","N",false,3,20,25.025,-6256.26,25000,"SR1",false,true,false,false,false,false,3,false,false,"N"),
			//Test Case 11
			$(21,0,25,"T","N",false,3,20,25.025,-6256.25,25000,"SR1",false,true,false,false,false,false,3,false,false,"N"),
			//Test Case 12
			$(21,60649.99,25,"T","N",false,3,20,25.025,54393.74,25000,"SR1",false,false,true,false,false,false,3,false,false,"N"),
			//Test Case 13
			$(21,60650,25,"T","N",false,3,20,25.025,54393.75,25000,"SR1",false,false,true,false,false,false,3,false,false,"N"),
			//Test Case 14
			$(5,60650,25,"H","N",false,3,4,25.0375,60650,150000,"SR3",true,false,false,false,true,true,2,false,false,"F"),
			//Test Case 15
			$(6,60650,25,"H","N",false,3,5,25.03125,60650,50000,"SR2",true,false,false,true,false,false,3,false,false,"N"),
			//Test Case 16
			$(5,60650,25,"H","F",false,3,4,25.0375,60650,150000,"SR3",true,false,false,false,false,false,3,false,false,"F"),
			//Test Case 17
			$(5,60650,25,"H","N",false,4,4,25.0375,60650,150000,"SR3",true,false,false,true,false,false,4,false,false,"N"),
			//Test Case 18
			$(5,60650,25,"H","N",false,2,4,25.0375,60650,150000,"SR3",true,false,false,true,false,false,2,false,false,"N"),
			//Test Case 19
			$(5,60650,25,"H","N",true,1,4,25.0375,60650,150000,"SR3",true,false,false,false,true,true,0,false,false,"N"),
			//Test Case 20
			$(5,60650,25,"H","N",false,1,4,25.0375,60650,150000,"SR3",true,false,false,true,false,false,1,false,false,"N"),
			//Test Case 21
			$(5,60650,25,"H","N",true,-1,4,25.0375,60650,150000,"SR3",true,false,false,false,false,true,-1,false,false,"N"),
			//Test Case 22
			$(20,60650,25,"H","N",false,4,19,25.03125,60650,50000,"SR2",true,false,false,true,false,false,4,false,false,"N"),
			//Test Case 23
			$(21,60650,25,"H","N",false,4,20,25.025,60650,25000,"SR1",true,false,false,false,false,false,4,false,false,"N"),
			//Test Case 24
			$(20,60650,25,"H","F",false,4,19,25.03125,60650,50000,"SR2",true,false,false,false,false,false,4,false,false,"F"),
			//Test Case 25
			$(20,60650,25,"H","N",true,4,19,25.03125,60650,50000,"SR2",true,false,false,false,true,true,3,false,false,"N"),
			//Test Case 26
			$(2,60650,25,"H","N",false,4,1,25.0375,60650,150000,"SR3",true,false,false,true,false,false,4,false,false,"N"),
			//Test Case 27
			$(1,60650,25,"H","N",false,4,0,25.0,60650,0,"End",false,false,false,true,false,false,4,true,false,"N"),
			//Test Case 28
			$(2,60650,25,"T","N",false,4,1,25.0375,23093.75,150000,"SR3",false,false,true,true,false,false,4,false,false,"N"),
			//Test Case 29
			$(2,60650,25,"T","F",false,4,1,25.0375,60650.0,150000,"SR3",true,false,false,false,false,false,4,false,false,"F"),
			//Test Case 30
			$(2,60650,25,"T","N",true,4,1,25.0375,60650.0,150000,"SR3",true,false,false,false,true,true,3,false,false,"N"),
			//Test Case 31
			$(1,60649.99,25,"T","N",true,4,0,25.0,60649.99,0,"End",false,false,true,false,true,true,3,false,true,"N"),
			//Test Case 32
			$(1,-0.01,25,"T","N",true,3,0,25.0,-0.01,0,"End",false,true,false,false,true,true,2,true,false,"F")
		
			
			
			
			);
    }
        
     @Test
     @Parameters(method="data")
    public void test(int input_ttl,double input_balance,double input_price,String input_BUYBtnState, String input_FUNDBtnState,boolean input_efund_purchase_latch,int input_efund_persistence_count,int output_ttl,double output_price,double output_balance,int output_volume,String output_STRP_state,boolean output_NTBUY,boolean output_BALN,boolean output_BAL10,boolean output_NFUND,boolean output_EFUND,boolean output_efund_purchase_latch,int output_efund_persistence_count,boolean output_FAIL,boolean output_PASS,String output_FUNDBtnState) 
     
     {
    	 
    	 Data data = new Data();
         data.setTTL(input_ttl);
         data.setBalance(input_balance);
         data.setPrice(input_price);
         data.setBUYBtnState(input_BUYBtnState);
         data.setFUNDBtnState(input_FUNDBtnState);
         
         Alerts alerts = new Alerts();
         alerts.setNTBUY(false);
         alerts.setBALN(false);
         alerts.setNFUND(false);
         alerts.setFAIL(false);
         alerts.setBAL10(false);
         alerts.setPASS(false);
         alerts.setEFUND(false);
         alerts.setEfund_purchase_latch(input_efund_purchase_latch);
         alerts.setEfund_persistence_count(input_efund_persistence_count);
     
         ComputeSimulationState p = new ComputeSimulationState();
         p.compute_state(data, alerts);
         int testttl = data.getTTL();
         double testoutput_price = data.getPrice();
         double testoutput_balance = data.getBalance();
         int testoutput_volume = data.getVolume();
         String testoutput_STRPState = data.getSTRP_state();
         boolean testoutput_NTBUY = alerts.isNTBUY();
         boolean testoutput_BALN = alerts.isBALN();
         boolean testoutput_BAL10 = alerts.isBAL10();
         boolean testoutput_NFUND = alerts.isNFUND();
         boolean testoutput_EFUND = alerts.isEFUND();
         boolean testoutput_efundplatch = alerts.isEfund_purchase_latch();
         int testoutput_efundpersistencecount = alerts.getEfund_persistence_count();
         boolean testoutput_FAIL = alerts.isFAIL();
         boolean testoutput_PASS = alerts.isPASS();
         String testoutput_FUNDBtnState = data.getFUNDBtnState();
    
         assertEquals(testttl,output_ttl);
         assertEquals(output_price,testoutput_price,0.001);
         assertEquals(output_balance,testoutput_balance,0.01);
         assertEquals(output_volume,testoutput_volume);
         assertEquals(output_STRP_state,testoutput_STRPState);
         assertEquals(output_NTBUY,testoutput_NTBUY);
         assertEquals(output_BALN,testoutput_BALN);
         assertEquals(output_BAL10,testoutput_BAL10);
         assertEquals(output_NFUND,testoutput_NFUND);
         assertEquals(output_EFUND,testoutput_EFUND);
         assertEquals(output_efund_purchase_latch,testoutput_efundplatch);
         assertEquals(output_efund_persistence_count,testoutput_efundpersistencecount);
         assertEquals(output_FAIL,testoutput_FAIL);
         assertEquals(output_PASS,testoutput_PASS);
         assertEquals(output_FUNDBtnState,testoutput_FUNDBtnState);
    }  
}