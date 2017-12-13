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
	private Money remainingMoney;
	private Money chargeMoney;
	
	private JLabel ableMoneyKinds = new JLabel("無し");
	private JLabel remainingMoneyLabel = new JLabel("0");
	private JLabel chargeMoneyLabel = new JLabel("0");
	
	public PaymentModeUi(Money remainingMoney_in, Money chargeMoney_in) {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelC = new JPanel();
		this.add(panelC, BorderLayout.NORTH);
		panelC.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel label1 = new JLabel("入金");
		panelC.add(label1);
		label1.setFont(new Font("Dialog", Font.BOLD, 30));
		
		JPanel panelS = new JPanel();
		this.add(panelS);
		panelS.setLayout(new BorderLayout(0, 0));
		
		JPanel panelSS = new JPanel();
		panelS.add(panelSS, BorderLayout.SOUTH);
		panelSS.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton chargeButton = new JButton("チャージ！！");
		chargeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO:チャージをリメインに加算する
				//TODO:加算した後のチャージを空にする
				update();
			}
		});
		panelSS.add(chargeButton);
		
		JPanel panelSN = new JPanel();
		panelS.add(panelSN, BorderLayout.NORTH);
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
		
		JPanel panelSC = new JPanel();
		panelS.add(panelSC, BorderLayout.CENTER);
		
		JLabel label3 = new JLabel("残額：");
		panelSC.add(label3);
		
		panelSC.add(remainingMoneyLabel);
		
		JLabel label4 = new JLabel("　　チャージ額：");
		panelSC.add(label4);
		
		panelSC.add(chargeMoneyLabel);
		
		remainingMoney = remainingMoney_in;
		chargeMoney = chargeMoney_in;
		update();
	}
	
	public void update() {
		remainingMoneyLabel.setText(String.valueOf(remainingMoney.getMoney()));
		chargeMoneyLabel.setText(String.valueOf(chargeMoney.getMoney()));
	}
}
