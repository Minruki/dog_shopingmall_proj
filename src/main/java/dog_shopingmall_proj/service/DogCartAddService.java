package dog_shopingmall_proj.service;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dog_shopingmall_proj.dao.impl.DogDAOImpl;
import dog_shopingmall_proj.ds.JndiDS;
import dog_shopingmall_proj.dto.Cart;
import dog_shopingmall_proj.dto.Dog;

public class DogCartAddService {

	private DogDAOImpl dao = DogDAOImpl.getInstance();
	private Connection con = JndiDS.getConnection();
	
	public DogCartAddService() {
		dao.setCon(con);
	}
	
	public Dog getCartDog(int id) {
		return dao.selectDog(id);
	}
	
	@SuppressWarnings("unchecked")
	public void addCart(HttpServletRequest request, Dog cartDog) {
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute("cartList");
		
		if (cartList == null) {
			cartList = new ArrayList<Cart>();
			session.setAttribute("cartList", cartList);
		}
		
		boolean isNewCart = true;
		for(Cart cart : cartList) {
			if (cartDog.getKind().equals(cart.getKind())) {
				isNewCart = false;
				cart.setQty(cart.getQty() + 1);
				break;
			}
		}
		
		if (isNewCart) {
			Cart cart = new Cart(
					cartDog.getImage(), 
					cartDog.getKind(), 
					cartDog.getPrice(), 
					1);
			cartList.add(cart);
		}
	}
}
