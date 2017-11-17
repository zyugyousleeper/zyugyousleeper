package model;

public abstract class Item {
	private String text = "Text";
	
	abstract public void run();
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
}
