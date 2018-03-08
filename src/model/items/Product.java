package model.items;

import java.awt.event.ActionListener;

public class Product implements Item {
	
	private String name = "";
	private int price = 0;
	private ActionListener listener;
	
	public void setText(String name) {
		this.name = name;
	}
	
	public void setlistener(ActionListener listener) {
		this.listener = listener;
	}

	@Override
	public String getText() {
		return name;
	}

	@Override
	public ActionListener getActionListener() {
		return listener;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
