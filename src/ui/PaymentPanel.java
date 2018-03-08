package ui;

import java.awt.BorderLayout;

import model.Money;
import wrapper.LabelWrapper;
import wrapper.PanelWrapper;

import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.Color;

public class PaymentPanel extends PanelWrapper{
	private Money remainingMoney = new Money();
	
	private LabelWrapper ableMoneyKinds = new LabelWrapper();
	private LabelWrapper remainingMoneyLabel = new LabelWrapper();
	
	public PaymentPanel() {
		super();
		ableMoneyKinds.setText("無し");
		remainingMoneyLabel.setText("0");
	
		setLayout(new BorderLayout(0, 0));
		
		PanelWrapper panelN = new PanelWrapper();
		this.add(panelN, BorderLayout.NORTH);
		panelN.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		LabelWrapper label1 = new LabelWrapper();
		label1.setText("入金");
		panelN.add(label1);
		label1.setFont(new Font("Dialog", Font.BOLD, 50));
		
		PanelWrapper panelC = new PanelWrapper();
		this.add(panelC);
		panelC.setLayout(new BorderLayout(0, 0));
		
		PanelWrapper panelSN = new PanelWrapper();
		panelC.add(panelSN, BorderLayout.NORTH);
		panelSN.setLayout(new BorderLayout(0, 0));
		
		PanelWrapper panelSNN = new PanelWrapper();
		panelSN.add(panelSNN, BorderLayout.NORTH);
		
		LabelWrapper label2 = new LabelWrapper();
		label2.setText("お金を入れて下さい");
		panelSNN.add(label2);
		label2.setFont(new Font("Dialog", Font.BOLD, 45));
		
		PanelWrapper panelSNC = new PanelWrapper();
		panelSN.add(panelSNC);
		
		LabelWrapper label5 = new LabelWrapper();
		label5.setText("投入できる貨幣：");
		label5.setFont(new Font("Dialog", Font.BOLD, 40));
		ableMoneyKinds.setFont(new Font("Dialog", Font.BOLD, 40));
		panelSNC.add(label5);		
		panelSNC.add(ableMoneyKinds);
		
		PanelWrapper panelS = new PanelWrapper();
		add(panelS, BorderLayout.SOUTH);
		panelS.setLayout(new BorderLayout(0, 0));
		
		PanelWrapper panelSC = new PanelWrapper();
		panelS.add(panelSC, BorderLayout.CENTER);
		
		LabelWrapper label3 = new LabelWrapper();
		label3.setText("残額：");
		label3.setFont(new Font("Dialog", Font.BOLD, 40));
		remainingMoneyLabel.setFont(new Font("Dialog", Font.BOLD, 40));
		panelSC.add(label3);
		remainingMoneyLabel.setForeground(Color.LIGHT_GRAY);
		label3.setForeground(Color.LIGHT_GRAY);
		
		panelSC.add(remainingMoneyLabel);
		
		LabelWrapper lavel5 = new LabelWrapper();
		label5.setText("円");
		lavel5.setFont(new Font("Dialog", Font.BOLD, 40));
		panelSC.add(lavel5);
	}
	
	public void setMoneyKinds(int... moneyKinds) {
		String string = new String();
		for (int kind : moneyKinds) {
			string += String.valueOf(kind) + "円,";
		}
		ableMoneyKinds.setText(string.substring(0, string.length() - 1));
	}
		
	public void update(Money remainingMoney_in) {
		remainingMoney = remainingMoney_in;
		remainingMoneyLabel.setText(String.valueOf(remainingMoney.getMoney()));
	}
}
