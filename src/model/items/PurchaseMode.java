package model.items;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import ui.ModeFrame;

public class PurchaseMode extends ModeFrame implements Item {
	public PurchaseMode() {

	}

	@Override
	public String getText() {
		return "PurchaseMode";
	}

	@Override
	public ActionListener getActionListener() {
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		};
	}
}
