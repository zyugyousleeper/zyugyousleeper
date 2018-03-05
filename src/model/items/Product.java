package model.items;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Product implements Item {

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return "商品";
	}

	@Override
	public ActionListener getActionListener() {
		// TODO Auto-generated method stub
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		};
	}

}
