package model.items;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Money;
import model.User;
import ui.ConfirmationPanel;
import ui.ContainerPanel;
import ui.EndingPanel;
import ui.ModeFrame;
import utils.Products;
import utils.Utils;

public class PurchaseMode extends ModeFrame implements Item{
	private User user;
	
	private ContainerPanel<Product> panel = new ContainerPanel<>();
	private ConfirmationPanel panel2 = new ConfirmationPanel();
	private EndingPanel panel3 = new EndingPanel();
	
	public PurchaseMode(User user_) {
		super();
		this.user = user_;
		
		//商品一覧を作成
		for(Product p : Products.products()) {
			p.setlistener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					panel2.setUser(user);
					panel2.setProduct(p);
					panel2.setupUI();
					next();
				}
			});
			panel.addItem(p);
		}
		
		//okbuttonの処理
		panel2.setOKListener((new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Money newMoney = new Money(user.getMoney().getMoney()-panel2.getProduct().getPrice());
				user.setMoney(newMoney);
				try {
					Utils.patchUser(user);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				next();
			}
		}));
		//cancelbttonの処理
		panel2.setCancelListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				back();
				setVisible(false);
			}
		});

		addPanel(panel);
		addPanel(panel2);
		addPanel(panel3);
	}

	
	
	@Override
	public String getText() {
		return "ものを購入";
	}

	@Override
	public ActionListener getActionListener() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(true);
			}
		};
	}
}
