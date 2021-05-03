package dog_shopingmall_proj.service;

import java.sql.Connection;

import dog_shopingmall_proj.dao.impl.DogDAOImpl;
import dog_shopingmall_proj.ds.JndiDS;
import dog_shopingmall_proj.dto.Dog;

public class DogRegistService {

	private DogDAOImpl dao = DogDAOImpl.getInstance();
	private Connection con = JndiDS.getConnection();
	
	public DogRegistService() {
		dao.setCon(con);
	}
	
	public boolean registDog(Dog dog){
		return dao.insertDog(dog) == 1 ? true : false;
	}
}
