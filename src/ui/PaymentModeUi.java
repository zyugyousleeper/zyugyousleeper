package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import model.Money;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;

public class PaymentModeUi extends JPanel{
	private Money remainingMoney = new Money();
	private Money chargeMoney = new Money();
	
	private JLabel ableMoneyKinds = new JLabel("無し");
	private JLabel remainingMoneyLabel = new JLabel("0");
	private JLabel necessaryMoneyLabel = new JLabel("0");
	
	public PaymentModeUi() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelN = new JPanel();
		this.add(panelN, BorderLayout.NORTH);
		panelN.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel label1 = new JLabel("入金");
		panelN.add(label1);
		label1.setFont(new Font("Dialog", Font.BOLD, 30));
		
		JPanel panelC = new JPanel();
		this.add(panelC);
		panelC.setLayout(new BorderLayout(0, 0));
		
		JPanel panelSN = new JPanel();
		panelC.add(panelSN, BorderLayout.NORTH);
		panelSN.setLayout(new BorderLayout(0, 0));
		
		JPanel panelSNN = new JPanel();
		panelSN.add(panelSNN, BorderLayout.NORTH);
		
		JLabel label2 = new JLabel("お金を入れて下さい");
		panelSNN.add(label2);
		label2.setFont(new Font("Dialog", Font.BOLD, 15));
		
		JPanel panelSNC = new JPanel();
		panelSN.add(panelSNC);
		
		JLabel label5 = new JLabel("投入できる貨幣：");
		panelSNC.add(label5);
		
		panelSNC.add(ableMoneyKinds);
		
		JPanel panelS = new JPanel();
		add(panelS, BorderLayout.SOUTH);
		panelS.setLayout(new BorderLayout(0, 0));
		
		JPanel panelSC = new JPanel();
		panelS.add(panelSC, BorderLayout.CENTER);
		
		JLabel label3 = new JLabel("残額：");
		panelSC.add(label3);
		
		panelSC.add(remainingMoneyLabel);
		
		JLabel lavel5 = new JLabel("円");
		panelSC.add(lavel5);
		
		JPanel panel = new JPanel();
		panelS.add(panel, BorderLayout.SOUTH);
		
		JLabel label4 = new JLabel("必要額：");
		panel.add(label4);
		
		panel.add(necessaryMoneyLabel);
		
		JLabel lavel6 = new JLabel("円");
		panel.add(lavel6);
	}
	
	public void update() {
		remainingMoneyLabel.setText(String.valueOf(remainingMoney.getMoney()));
		necessaryMoneyLabel.setText(String.valueOf(chargeMoney.getMoney()));
	}
}
