package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.print.DocFlavor.INPUT_STREAM;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import model.Money;
import wrapper.PanelWrapper;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.awt.Color;

public class PaymentPanel extends PanelWrapper{
	private Money remainingMoney = new Money();
	
	private JLabel ableMoneyKinds = new JLabel("無し");
	private JLabel remainingMoneyLabel = new JLabel("0");
	
	public PaymentPanel() {
		setBackground(Color.DARK_GRAY);
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelN = new JPanel();
		this.add(panelN, BorderLayout.NORTH);
		panelN.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel label1 = new JLabel("入金");
		label1.setForeground(Color.LIGHT_GRAY);
		panelN.add(label1);
		label1.setFont(new Font("Dialog", Font.BOLD, 50));
		
		JPanel panelC = new JPanel();
		this.add(panelC);
		panelC.setLayout(new BorderLayout(0, 0));
		
		JPanel panelSN = new JPanel();
		panelC.add(panelSN, BorderLayout.NORTH);
		panelSN.setLayout(new BorderLayout(0, 0));
		
		JPanel panelSNN = new JPanel();
		panelSN.add(panelSNN, BorderLayout.NORTH);
		
		JLabel label2 = new JLabel("お金を入れて下さい");
		label2.setForeground(Color.LIGHT_GRAY);
		panelSNN.add(label2);
		label2.setFont(new Font("Dialog", Font.BOLD, 45));
		
		JPanel panelSNC = new JPanel();
		panelSN.add(panelSNC);
		
		JLabel label5 = new JLabel("投入できる貨幣：");
		label5.setFont(new Font("Dialog", Font.BOLD, 40));
		ableMoneyKinds.setFont(new Font("Dialog", Font.BOLD, 40));
		label5.setForeground(Color.LIGHT_GRAY);
		ableMoneyKinds.setForeground(Color.LIGHT_GRAY);
		panelSNC.add(label5);		
		panelSNC.add(ableMoneyKinds);
		
		JPanel panelS = new JPanel();
		add(panelS, BorderLayout.SOUTH);
		panelS.setLayout(new BorderLayout(0, 0));
		
		JPanel panelSC = new JPanel();
		panelS.add(panelSC, BorderLayout.CENTER);
		
		JLabel label3 = new JLabel("残額：");
		label3.setFont(new Font("Dialog", Font.BOLD, 40));
		remainingMoneyLabel.setFont(new Font("Dialog", Font.BOLD, 40));
		panelSC.add(label3);
		remainingMoneyLabel.setForeground(Color.LIGHT_GRAY);
		label3.setForeground(Color.LIGHT_GRAY);
		
		panelSC.add(remainingMoneyLabel);
		
		JLabel lavel5 = new JLabel("円");
		lavel5.setFont(new Font("Dialog", Font.BOLD, 40));
		lavel5.setForeground(Color.LIGHT_GRAY);
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
