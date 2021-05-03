package dog_shopingmall_proj.service;

import java.sql.Connection;
import java.util.List;

import dog_shopingmall_proj.dao.impl.DogDAOImpl;
import dog_shopingmall_proj.ds.JndiDS;
import dog_shopingmall_proj.dto.Dog;

public class DogListService {

	private DogDAOImpl dao = DogDAOImpl.getInstance();
	private Connection con = JndiDS.getConnection();
	
	public DogListService() {
		dao.setCon(con);
	}
	
	public List<Dog> getDogList(){
		return dao.selectDogList();
	}
}
