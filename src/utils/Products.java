package utils;

import java.util.ArrayList;

import model.items.Product;

public class Products {
	public static ArrayList<Product> products(){
		Product p1 = new Product();
		p1.setText("ちょこれーと");
		p1.setPrice(100);
		Product p2 = new Product();
		p2.setText("こーひー");
		p2.setPrice(10);
		Product p3 = new Product();
		p3.setText("ここあ");
		p3.setPrice(1000);

		ArrayList<Product> list = new ArrayList<>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		return list;
	}
	
}
