package DTTS;

import javax.swing.JPanel;

	import java.awt.BorderLayout;

import javax.swing.JFrame;
//	import javax.swing.JPanel;
	import javax.swing.border.EmptyBorder;

	import java.awt.Color;
import java.awt.Font;

	import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;

import javax.swing.border.BevelBorder;

import DTTS.Data.button_pressed;

	@SuppressWarnings("serial")

	public class DTTSDisplay extends JFrame {

		private JPanel contentPane;
		private JTextField STRPPanel;
		private JTextField BAL10Panel;
		private JTextField PassPanel;
		JTextField EFUNDPanel = new JTextField();
		JTextField NFUNDPanel = new JTextField();
		JTextField BALNPanel = new JTextField();
		JTextField NTBUYPanel = new JTextField();
		JTextField TICKPanel = new JTextField();
		JTextField FAILPanel = new JTextField();	
		JTextField TTLPanel = new JTextField();
		JTextField PrcPanel = new JTextField();
		JTextField BalancePanel = new JTextField();
		JTextField terrTextField = new JTextField();
		JTextField SHDPOSPanel = new JTextField();
		JTextField SHDCMDPanel = new JTextField();
		JButton BUYbtnH = new JButton("H");
		JButton BUYbtnT = new JButton("T");
		JButton FUNDBtnN = new JButton("N");
		JButton FUNDBtnF = new JButton("F");
	 
		JFrame frame = new JFrame();
		private JTextField VolPanel;
		
	    
	    public void signedTextField(String symbol, boolean possign, boolean negsign, int value, JTextField textField)
	    {
	    	String symb1="",symb2="";
	    	if (negsign)
	        	symb2 = "-";
	        if (possign)
	        	symb1 = "+";

	        if(value > 0)
	        	textField.setText(symb1 + symbol + value);
	        if (value < 0)
		        textField.setText(symb2 + symbol + value);
	    }

	    
		private void updateAlert (boolean alertSet, JTextField panelName) {
			if (alertSet) {
				panelName.setBackground(Color.RED);
				panelName.setForeground(Color.WHITE);
				}
			else
			{
				panelName.setBackground(Color.WHITE);
				panelName.setForeground(Color.BLACK);
			}	
		}
		
		private void updateWarning (boolean alertSet, JTextField panelName) {
			if (alertSet)
				panelName.setBackground(Color.YELLOW);
			else
				panelName.setBackground(Color.WHITE);
		}
		
		private void updateIndicator (boolean alertSet, JTextField panelName) {
			if (alertSet)
				panelName.setBackground(Color.GREEN);
			else
				panelName.setBackground(Color.WHITE);
		}

		
		public void updateDisplay(Data data, Alerts alerts) {
			updateAlert(alerts.isNTBUY(),NTBUYPanel);
			updateAlert(alerts.isBALN(),BALNPanel);
			updateAlert(alerts.isNFUND(),NFUNDPanel);
			updateAlert(alerts.isFAIL(),FAILPanel);
			updateWarning(alerts.isEFUND(),EFUNDPanel);
			updateIndicator(alerts.isBAL10(),BAL10Panel);
			updateIndicator(alerts.isPASS(),PassPanel);
			
			BUYbtnH.setBackground(Color.WHITE);				
			if (data.getBUYBtnState()=="T")
				BUYbtnT.setBackground(Color.GREEN);
			else
				BUYbtnT.setBackground(Color.WHITE);
				
			FUNDBtnN.setBackground(Color.WHITE);
			if (data.getFUNDBtnState()=="F")
				FUNDBtnF.setBackground(Color.GREEN);
			else
				FUNDBtnF.setBackground(Color.WHITE);
				
	        DecimalFormat sig0 = new DecimalFormat("#");
//	        sig0.setRoundingMode(RoundingMode.DOWN);
	        DecimalFormat sig2 = new DecimalFormat("#.00");
	        DecimalFormat csv = new DecimalFormat("$###,###.00");
	        DecimalFormat sig0csv = new DecimalFormat("###,###");
//	        sig2.setRoundingMode(RoundingMode.DOWN);
	        
	        float priceval = new Float(sig2.format(data.getPrice()));
	        float balval = new Float(sig2.format(data.getBalance()));      
	        PrcPanel.setText("$"+sig2.format(priceval));
	        BalancePanel.setText(csv.format(balval));
	        TTLPanel.setText(sig0.format(data.getTTL()));
	        VolPanel.setText(sig0csv.format(data.getVolume()));
	        STRPPanel.setText(data.getSTRP_state());
			TICKPanel.setText(data.getTICK());

			// print data values only if Printdata is set
		}



		public void makeFrame() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(new BorderLayout(0, 0));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			frame.setVisible(true);
			frame.setBounds(100, 100, 450, 300);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
		}
		private void addComponents (Data data, Alerts alerts) {
			
			JPanel ALERTpanel = new JPanel();
			ALERTpanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
			ALERTpanel.setBounds(10, 23, 202, 27);
			frame.getContentPane().add(ALERTpanel);
			ALERTpanel.setLayout(null);
			NTBUYPanel.setEditable(false);
			NTBUYPanel.setBounds(5, 3, 47, 20);
			ALERTpanel.add(NTBUYPanel);
			NTBUYPanel.setHorizontalAlignment(SwingConstants.CENTER);
			NTBUYPanel.setText("NTBUY");
			NTBUYPanel.setColumns(10);
			BALNPanel.setEditable(false);
			BALNPanel.setBounds(55, 3, 45, 20);
			ALERTpanel.add(BALNPanel);
			BALNPanel.setHorizontalAlignment(SwingConstants.CENTER);
			BALNPanel.setText("BALN");
			BALNPanel.setColumns(10);
			NFUNDPanel.setEditable(false);
			NFUNDPanel.setBounds(102, 3, 52, 20);
			ALERTpanel.add(NFUNDPanel);
			NFUNDPanel.setHorizontalAlignment(SwingConstants.CENTER);
			NFUNDPanel.setText("NFUND");
			NFUNDPanel.setColumns(10);
			FAILPanel.setEditable(false);
			FAILPanel.setBounds(155, 3, 39, 20);
			ALERTpanel.add(FAILPanel);
			FAILPanel.setHorizontalAlignment(SwingConstants.CENTER);
			FAILPanel.setText("FAIL");
			FAILPanel.setColumns(10);
			
			JPanel WARNINGPanel = new JPanel();
			WARNINGPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
			WARNINGPanel.setBounds(300, 23, 55, 27);
			frame.getContentPane().add(WARNINGPanel);
			WARNINGPanel.setLayout(null);
			EFUNDPanel.setEditable(false);
			EFUNDPanel.setBounds(3, 3, 48, 20);
			WARNINGPanel.add(EFUNDPanel);
			EFUNDPanel.setHorizontalAlignment(SwingConstants.CENTER);
			EFUNDPanel.setText("EFUND");
			EFUNDPanel.setColumns(10);
			
			setVisible(true);
			
			JPanel Datapanel = new JPanel();
			Datapanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
			Datapanel.setBounds(50, 70, 160, 145);
			frame.getContentPane().add(Datapanel);
			Datapanel.setLayout(null);
			TTLPanel.setBounds(37, 5, 80, 20);
			Datapanel.add(TTLPanel);
			TTLPanel.setHorizontalAlignment(SwingConstants.RIGHT);
			TTLPanel.setText("");
			TTLPanel.setColumns(10);
			
						
						JLabel lblTTL = new JLabel("");
						lblTTL.setHorizontalAlignment(SwingConstants.RIGHT);
						lblTTL.setBounds(18, 10, 20, 14);
						Datapanel.add(lblTTL);
						lblTTL.setText("TTL");
						lblTTL.setFont(new Font("Tahoma", Font.PLAIN,11));
						
						JLabel lblmins = new JLabel("");
						lblmins.setBounds(120, 10, 25, 14);
						Datapanel.add(lblmins);
						lblmins.setText("mins");
						lblmins.setFont(new Font("Tahoma", Font.PLAIN,11));
						TICKPanel.setBounds(37, 28, 80, 20);
						Datapanel.add(TICKPanel);
						TICKPanel.setHorizontalAlignment(SwingConstants.RIGHT);
						TICKPanel.setColumns(10);
						
									JLabel lblTICK = new JLabel("Vel");
									lblTICK.setHorizontalAlignment(SwingConstants.RIGHT);
									lblTICK.setBounds(11, 30, 25, 14);
									Datapanel.add(lblTICK);
									lblTICK.setText("TICK");
									lblTICK.setFont(new Font("Tahoma", Font.PLAIN,11));
									PrcPanel.setBounds(37, 51, 80, 20);
									Datapanel.add(PrcPanel);
									
									PrcPanel.setText("");
									PrcPanel.setHorizontalAlignment(SwingConstants.RIGHT);
									PrcPanel.setColumns(10);
									
									JLabel lblPrc = new JLabel("Prc");
									lblPrc.setHorizontalAlignment(SwingConstants.RIGHT);
									lblPrc.setBounds(16, 52, 20, 14);
									Datapanel.add(lblPrc);
									lblPrc.setFont(new Font("Tahoma", Font.PLAIN,11));
									
									VolPanel = new JTextField();
									VolPanel.setHorizontalAlignment(SwingConstants.RIGHT);
									VolPanel.setBounds(37, 73, 80, 20);
									Datapanel.add(VolPanel);
									VolPanel.setColumns(10);
									
									JLabel lblVol = new JLabel("sh/m");
									lblVol.setBounds(120, 76, 25, 14);
									Datapanel.add(lblVol);
									lblVol.setFont(new Font("Tahoma", Font.PLAIN,11));
									
									JLabel lblNewLabel = new JLabel("Vol");
									lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
									lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
									lblNewLabel.setBounds(16, 76, 20, 14);
									Datapanel.add(lblNewLabel);
									BalancePanel.setBounds(37, 95, 80, 20);
									Datapanel.add(BalancePanel);
									BalancePanel.setHorizontalAlignment(SwingConstants.RIGHT);
									BalancePanel.setColumns(10);
									
									JLabel lblBal = new JLabel("Bal");
									lblBal.setHorizontalAlignment(SwingConstants.RIGHT);
									lblBal.setBounds(15, 95, 20, 20);
									Datapanel.add(lblBal);
									lblBal.setFont(new Font("Tahoma", Font.PLAIN,11));
									
									STRPPanel = new JTextField();
									STRPPanel.setBounds(37, 117, 80, 20);
									Datapanel.add(STRPPanel);
									STRPPanel.setHorizontalAlignment(SwingConstants.RIGHT);
									STRPPanel.setColumns(10);
									
									JLabel lblSTRP = new JLabel("STRP");
									lblSTRP.setBounds(11, 119, 25, 14);
									Datapanel.add(lblSTRP);
									lblSTRP.setHorizontalAlignment(SwingConstants.RIGHT);
									lblSTRP.setFont(new Font("Tahoma", Font.PLAIN,11));
			
			JPanel Indicatorpanel = new JPanel();
			Indicatorpanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
			Indicatorpanel.setBounds(232, 77, 90, 25);
			frame.getContentPane().add(Indicatorpanel);
			Indicatorpanel.setLayout(null);
			
			BAL10Panel = new JTextField();
			BAL10Panel.setEditable(false);
			BAL10Panel.setBounds(3, 3, 40, 20);
			Indicatorpanel.add(BAL10Panel);
			BAL10Panel.setText("BAL10");
			BAL10Panel.setFont(new Font("Tahoma", Font.PLAIN, 11));
			BAL10Panel.setHorizontalAlignment(SwingConstants.CENTER);
			BAL10Panel.setColumns(10);
			
			PassPanel = new JTextField();
			PassPanel.setFont(new Font("Tahoma", Font.PLAIN, 11));
			PassPanel.setEditable(false);
			PassPanel.setBounds(46, 3, 40, 20);
			Indicatorpanel.add(PassPanel);
			PassPanel.setText("PASS");
			PassPanel.setHorizontalAlignment(SwingConstants.CENTER);
			PassPanel.setColumns(10);
			
			JLabel DataPanelLbl = new JLabel("Data Panel");
			DataPanelLbl.setBounds(70, 55, 90, 14);
			frame.getContentPane().add(DataPanelLbl);
			
			JLabel lblIndicatorPanel = new JLabel("Indicator Panel");
			lblIndicatorPanel.setBounds(232, 62, 90, 14);
			frame.getContentPane().add(lblIndicatorPanel);
			
			JPanel Switchpanel = new JPanel();
			Switchpanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
			Switchpanel.setBounds(228, 125, 108, 90);
			frame.getContentPane().add(Switchpanel);
			Switchpanel.setLayout(null);
			
			JPanel FUNDBTNPanel = new JPanel();
			FUNDBTNPanel.setBounds(55, 5, 48, 80);
			Switchpanel.add(FUNDBTNPanel);
			FUNDBTNPanel.setLayout(null);
			
			JLabel FUNDlabel = new JLabel("FUND");
			FUNDlabel.setHorizontalAlignment(SwingConstants.CENTER);
			FUNDlabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
			FUNDlabel.setBounds(12, 5, 30, 18);
			FUNDBTNPanel.add(FUNDlabel);
			
			FUNDBtnN.setFont(new Font("Tahoma", Font.PLAIN, 11));
			FUNDBtnN.setBounds(2, 24, 45, 23);
			FUNDBTNPanel.add(FUNDBtnN);

			FUNDBTNPanel.add(FUNDBtnF);
			JPanel BUYBTNPanel = new JPanel();
			BUYBTNPanel.setBounds(3, 5, 50, 80);
			Switchpanel.add(BUYBTNPanel);
			BUYBTNPanel.setLayout(null);
			
			JLabel lblBUYbtn = new JLabel("BUY");
			lblBUYbtn.setHorizontalAlignment(SwingConstants.CENTER);
			lblBUYbtn.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblBUYbtn.setBounds(12, 5, 27, 18);
			BUYBTNPanel.add(lblBUYbtn);
			BUYbtnH.setFont(new Font("Tahoma", Font.PLAIN, 11));
			BUYbtnH.setBounds(3, 24, 45, 23);
			FUNDBtnF.setFont(new Font("Tahoma", Font.PLAIN, 11));
			FUNDBtnF.setBounds(2, 52, 45, 23);
			BUYBTNPanel.add(BUYbtnH);
			BUYbtnT.setFont(new Font("Tahoma", Font.PLAIN, 11));
			BUYbtnT.setBounds(3, 52, 45, 23);
			BUYBTNPanel.add(BUYbtnT);

			FUNDBtnN.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
/* ***DEBUG  */		data.setBtnPressed(button_pressed.FUNDN);
					if (!data.isfundBtnFLatch())
						data.setFUNDBtnState("N");
				}
			});		
			FUNDBtnF.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					data.setFUNDBtnState("F");
					data.setfundBtnFLatch(true);
/* ***DEBUG  */		data.setBtnPressed(button_pressed.FUNDF);
				}
			});			
			BUYbtnH.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
/* ***DEBUG  */		data.setBtnPressed(button_pressed.BUYH);
					data.setBUYBtnState("H");
			}});			
			BUYbtnT.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
/* ***DEBUG  */		data.setBtnPressed(button_pressed.BUYT);
					data.setBUYBtnState("T"); 
			}});
			
			JLabel Switchlabel = new JLabel("Switches");
			Switchlabel.setBounds(229, 108, 60, 14);
			frame.getContentPane().add(Switchlabel);
			
			JLabel AlertPanelLbl = new JLabel(" Alert Panel");
			AlertPanelLbl.setHorizontalAlignment(SwingConstants.LEFT);
			AlertPanelLbl.setBounds(12, 5, 80, 20);
			frame.getContentPane().add(AlertPanelLbl);
			
			JLabel lblNewLabel_1 = new JLabel("Warning Panel");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel_1.setBounds(300, 5, 100, 20);
			frame.getContentPane().add(lblNewLabel_1);
			
			}
			
		public DTTSDisplay(Data data, Alerts alerts) {
			makeFrame();
			addComponents(data,alerts);
		}
		}
