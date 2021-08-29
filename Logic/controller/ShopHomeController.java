package controller;

import dao.ShopRepository;
import dao.UserDao;
import entity.ShopUser;
import javafx.stage.Window;

public class ShopHomeController {



	private ShopUser currentUser;

	public ShopUser getCurrentUser() {
		return currentUser;
	}
	
	public void setCurrentUser(ShopUser currentUser) {
		this.currentUser = currentUser;
	}


	public void deleteAccount(int id) {
		UserDao userd = new UserDao();
		userd.delete(id);
	}

	public void initDataShop(int id, Object shopBean) {
		ShopRepository sd = new ShopRepository();
		currentUser = sd.getShopByID(id);
		if(shopBean.getClass() == bean.ShopHomeBoundary.class) {
		((bean.ShopHomeBoundary) shopBean).initData(currentUser.getId(), currentUser.getNome());
		}
		else if(shopBean.getClass() == beanweb.ShopHomeBoundary.class) {
			((beanweb.ShopHomeBoundary) shopBean).getInstance().initData(currentUser.getId(), currentUser.getNome(), currentUser.getEmail());
			}
	}


}
