package controller;

import dao.UserDao;
import dao.VolunteerRepository;
import entity.VolunteerUser;



public  class UserHomeController{
	private VolunteerUser currentUser;
	
	public VolunteerUser getCurrentUser() {
		return currentUser;
	}
	
	public void setCurrentUser(VolunteerUser currentUser) {
		this.currentUser = currentUser;
	}

	
	public void deleteAccount(int id) {
		UserDao userd = new UserDao();
		userd.delete(id);
	}
	
	
	public void initDataCont(int id, Object userHomeBoundary) {
		VolunteerRepository userD = new VolunteerRepository();
		currentUser = userD.getVolunteerByID(id);
		if(userHomeBoundary.getClass() ==  bean.UserHomeBoundary.class) {
			((bean.UserHomeBoundary) userHomeBoundary).initData(currentUser.getNome(), currentUser.getCognome(), currentUser.getId());
		}
		else if(userHomeBoundary.getClass() == beanweb.UserHomeBoundary.class){
			((beanweb.UserHomeBoundary) userHomeBoundary).getInstance().initData(currentUser.getId(),currentUser.getCognome(), currentUser.getNome(), currentUser.getEmail());
		}
    }


}